package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorItemDeleteService implements AbstractDeleteService<Inventor, Item>{

	@Autowired
	protected InventorItemRepository repository;
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		final boolean result;
		int itemId;
		final Item item;
		final Inventor inventor;
		
		itemId=request.getModel().getInteger("id");
		item=this.repository.findItemlById(itemId);
		inventor=item.getInventor();
		
		result= !item.isPublished() && request.isPrincipal(inventor);
		
		
		return result;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "tipo", "name", "code", "technology", "description", "retailPrice", "optionalLink"); 
		
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "tipo", "name", "code", "technology", "description", "retailPrice", "optionalLink", "inventor.userAccount.username", "published"); 
		
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		
		Item result;
		int id;
		
		id=request.getModel().getInteger("id");
		result=this.repository.findItemlById(id);
		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		
		
		this.repository.delete(entity);
	}

}