package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor,Toolkit> {

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		boolean res=false;
		int id;
		int inventorId;
		int userId;
		id=request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findOneToolkitById(id);
		inventorId = toolkit.getInventor().getId();
		userId= request.getPrincipal().getAccountId();
		final Inventor invent=this.repository.findInventorByUserAccountId(userId);
		final int inventorIdUser=invent.getId();
		
		if(inventorId == inventorIdUser) {
			res=true;
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

		request.unbind(entity, model, "code", 
			"description","assemblyNotes", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}
	
	
	//Metodos adicionales
	
	private Money retailPriceOfToolkit(final int toolkitid) {
		final Money result = new Money();
		result.setAmount(0.0);
		result.setCurrency("EUR");
		
		final AuthenticatedMoneyExchangePerformService moneyExchange = new AuthenticatedMoneyExchangePerformService();
		final Collection<Quantity> quantitis=this.repository.findQuantityByToolkitId(toolkitid);
		
		for(final Quantity quantity:quantitis) {
			final Money moneyOfItem= quantity.getItem().getRetailPrice();
			final int numberOfItem = quantity.getNumber();
			final MoneyExchange exchangeMoneyOfItem = moneyExchange.computeMoneyExchange(moneyOfItem, "EUR");
			final Double newAmount = result.getAmount() + exchangeMoneyOfItem.getTarget().getAmount()*numberOfItem;
			result.setAmount(newAmount);
		}
		
		return result;
		
	}
		
		
		
		
		
	
	
	
	
	

}
