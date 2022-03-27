package acme.features.anonymous.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousItemShowService implements AbstractShowService<Anonymous, Item>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousItemRepository repository;
		
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
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

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "tipo", "name", "code", "technology",
			"description","retailPrice", "optionalLink", "item.inventor.userAccount.username");
		
	}

	

}
