package acme.features.any.toolkit;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.MoneyExchange;
import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyToolkitShowService implements AbstractShowService<Any, Toolkit>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyToolkitRepository repository;
			
		@Override
		public boolean authorise(final Request<Toolkit> request) {
			assert request != null;
			int id;
			id=request.getModel().getInteger("id");
			final Toolkit toolkit = this.repository.findOneToolkitById(id);
			return	toolkit.isPublished();
		}

		@Override
		public Toolkit findOne(final Request<Toolkit> request) {
			assert request != null;

			Toolkit result;
			int id;
			
			id = request.getModel().getInteger("id");
			result = this.repository.findOneToolkitById(id);
			return result;
		}
		
		/* Método que realiza conversiones de divisas. Si la divisa del objeto money que se pasa como parámetro
		 * es diferente de la divisa predeterminada de la configuración del sistema, entonces se obtiene o calcula 
		 * la conversión. En caso contrario, no es necesario realizar una conversión, por lo que los Money fuente y destino +
		 * son iguales. */
		public MoneyExchange conversion(final Money money) {
		
			final AuthenticatedMoneyExchangePerformService moneyExchange = new AuthenticatedMoneyExchangePerformService();
			
			MoneyExchange conversion = new MoneyExchange();
			
			final String systemCurrency = this.repository.findSystemCurrency();

			if(!money.getCurrency().equals(systemCurrency)) {
				conversion = this.repository.findMoneyExchangeByCurrencyAndAmount(money.getCurrency(), money.getAmount());
				
				if(conversion == null) {
					conversion = moneyExchange.computeMoneyExchange(money, systemCurrency);
					this.repository.save(conversion);
					
				}
				
			}else {
				conversion.setSource(money);
				conversion.setTarget(money);
				conversion.setCurrencyTarget(systemCurrency);
				conversion.setDate(new Date(System.currentTimeMillis()));
				
			}
			
			return conversion;
			
		}

		private Money retailPriceOfToolkit(final int toolkitid) {
			Money result = new Money();
			result.setAmount(0.0);
			result.setCurrency("EUR");
			
			final Collection<Quantity> quantitis=this.repository.findQuantityByToolkitId(toolkitid);
			final Toolkit toolkit = this.repository.findOneToolkitById(toolkitid);
			
			if(toolkit.getRetailPrice() == null) {
			
				for(final Quantity quantity:quantitis) {
					final Double conversionAmount;
					final Money moneyOfItem = quantity.getItem().getRetailPrice();
					final int numberOfItem = quantity.getNumber();
					
					conversionAmount = this.conversion(moneyOfItem).getTarget().getAmount();
					
					final Double newAmount = (double) Math.round((result.getAmount() + conversionAmount*numberOfItem)*100)/100;
					result.setAmount(newAmount);
				}
				
				toolkit.setRetailPrice(result);
			
			} else {
				result = toolkit.getRetailPrice();
			}
			
			return result;

		}

		@Override
		public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
			
			model.setAttribute("retailPrice", this.retailPriceOfToolkit(entity.getId()));
			
			
			request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "published",
				"optionalLink", "inventor.userAccount.username");
			
		}
		
		
		
		

}
