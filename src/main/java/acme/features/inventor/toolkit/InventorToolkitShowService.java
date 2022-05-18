
package acme.features.inventor.toolkit;

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
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit> {

	@Autowired
	protected InventorToolkitRepository repository;


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		boolean res = false;
		int id;
		int inventorId;
		int userId;
		id = request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findOneToolkitById(id);
		inventorId = toolkit.getInventor().getId();
		userId = request.getPrincipal().getAccountId();
		final Inventor invent = this.repository.findInventorByUserAccountId(userId);
		final int inventorIdUser = invent.getId();

		if (inventorId == inventorIdUser) {
			res = true;
		}

		return res;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		
		result.setRetailPrice(this.retailPriceOfToolkit(id));
		
		
		
		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("masterId", entity.getId());
		
		request.unbind(entity, model, "code","title", 
			"description","assemblyNotes","published", "optionalLink", 
			"inventor.userAccount.username","retailPrice");

	}

	//Metodos adicionales
	
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
		final Money result = new Money();
		result.setAmount(0.0);
		result.setCurrency("EUR");
		
		final Collection<Quantity> quantitis=this.repository.findQuantityByToolkitId(toolkitid);
		
		for(final Quantity quantity:quantitis) {
			final Double conversionAmount;
			final Money moneyOfItem = quantity.getItem().getRetailPrice();
			final int numberOfItem = quantity.getNumber();
			
			conversionAmount = this.conversion(moneyOfItem).getTarget().getAmount();
			
			final Double newAmount = (double) Math.round((result.getAmount() + conversionAmount*numberOfItem)*100)/100;
			result.setAmount(newAmount);
		}
		
		return result;

	}

}
