
package acme.features.inventor.quantity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.MoneyExchange;
import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.features.inventor.item.InventorItemRepository;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitItemShowService implements AbstractShowService<Inventor, Quantity> {

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Autowired
	protected InventorItemRepository itemRepository;


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;

		boolean res = false;
		int toolkitId;
		int quantityId;
		int inventorId;
		int userId;
		quantityId = request.getModel().getInteger("id");
		final Quantity quantity = this.repository.findOneQuantityById(quantityId);
		toolkitId= quantity.getToolkit().getId();
		final Toolkit toolkit = this.repository.findOneToolkitById(toolkitId);
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
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;

		Quantity result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneQuantityById(id);
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
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("toolkitPublished", entity.getToolkit().isPublished());
		final boolean differentCurrency = !entity.getItem().getRetailPrice().getCurrency().equals(this.itemRepository.findSystemCurrency());
		model.setAttribute("differentCurrency", differentCurrency);
		model.setAttribute("conversion", this.conversion(entity.getItem().getRetailPrice()).getTarget());

		request.unbind(entity, model, "number", "toolkit.code", "item.tipo", "item.name", "item.code", "item.retailPrice");

	}
}
