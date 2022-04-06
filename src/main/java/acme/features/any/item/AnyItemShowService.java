package acme.features.any.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
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
			
			model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
			
			request.unbind(entity, model, "tipo", "name", "code", "technology",
				"description","retailPrice", "optionalLink");
			
		}

}
