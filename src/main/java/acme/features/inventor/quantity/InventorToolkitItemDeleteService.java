package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorToolkitItemDeleteService implements AbstractDeleteService<Inventor, Quantity>{

	@Autowired
	protected InventorToolkitRepository repository;
	
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
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "number"); 
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "number", "item.tipo", "item.name", "item.code", "item.technology", "item.description", "item.retailPrice", "item.optionalLink", "item.inventor.userAccount.username","item.published"); 
		
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
	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		
		this.repository.delete(entity);
	}

}