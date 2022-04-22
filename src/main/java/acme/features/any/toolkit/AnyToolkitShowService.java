package acme.features.any.toolkit;

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
			
			result.setRetailPrice(this.retailPriceOfToolkit(id));
			
			
			
			return result;
		}

		@Override
		public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
			
			request.unbind(entity, model, "code", "description", "assemblyNotes", "published",
				"optionalLink", "retailPrice");
			
		}
		
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
