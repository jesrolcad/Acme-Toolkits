package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
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
		item = this.repository.findItemlById(itemId);
		result = item != null && item.getInventor().getId() == request.getPrincipal().getActiveRoleId();

		return result;

	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;

		Item result;
		int id;

		id = request.getModel().getInteger("id");

		result = this.repository.findItemlById(id);
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());

		request.unbind(entity, model, "tipo", "name", "code", "technology", "description", "retailPrice", "optionalLink", "inventor.userAccount.username", "published");

	}
}