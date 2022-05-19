package acme.features.any.item;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.MoneyExchange;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyItemShowService implements AbstractShowService<Any, Item>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyItemRepository repository;
			
		@Override
		public boolean authorise(final Request<Item> request) {
			assert request != null;

			boolean result;
			int id;
			final Item item;

			id = request.getModel().getInteger("id");
			item = this.repository.findOneItemById(id);
			result = item.isPublished();

			return result;
		}

		@Override
		public Item findOne(final Request<Item> request) {
			assert request != null;

			Item result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findOneItemById(id);

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

		@Override
		public void unbind(final Request<Item> request, final Item entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			model.setAttribute("conversion", this.conversion(entity.getRetailPrice()).getTarget());
			
			request.unbind(entity, model, "tipo", "name", "code", "technology",
				"description","retailPrice", "optionalLink", "inventor.userAccount.username","published");
			
		}

}
