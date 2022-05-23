package acme.features.inventor.item;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.MoneyExchange;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemShowService implements AbstractShowService<Inventor, Item> {

	@Autowired
	protected InventorItemRepository repository;


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		boolean result;
		int itemId;
		Item item;

		itemId = request.getModel().getInteger("id");
		item = this.repository.findItemById(itemId);
		result = item != null && item.getInventor().getId() == request.getPrincipal().getActiveRoleId();

		return result;

	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;

		Item result;
		int id;

		id = request.getModel().getInteger("id");

		result = this.repository.findItemById(id);
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
			conversion = this.repository.findMoneyExchangeByCurrencyAndAmount(money.getCurrency(), money.getAmount(),systemCurrency);
			
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
		
		final MoneyExchange conversion = this.conversion(entity.getRetailPrice());
		final boolean differentCurrency = !entity.getRetailPrice().getCurrency().equals(this.repository.findSystemCurrency());
		model.setAttribute("differentCurrency", differentCurrency);
		model.setAttribute("conversion", conversion.getTarget());
		request.unbind(entity, model, "tipo", "name", "code", "technology", "description", "retailPrice", "optionalLink", "inventor.userAccount.username", "published");

	}
}