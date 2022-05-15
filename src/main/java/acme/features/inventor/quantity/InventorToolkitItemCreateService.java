package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.features.inventor.item.InventorItemRepository;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
@Service
public class InventorToolkitItemCreateService  implements AbstractCreateService<Inventor, Quantity>{
	@Autowired
	protected InventorToolkitRepository toolkitRepository;

	
	@Autowired
	protected InventorItemRepository itemRepository;
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

			entity.setItem(this.itemRepository.findItemlById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
			request.bind(entity, errors, "number","itemId");
			
	}	
	


	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {

		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		System.out.println(request.getModel().getAttribute("masterId"));
		model.setAttribute("masterId", request.getModel().getAttribute("masterId"));
		model.setAttribute("items", this.itemRepository.findManyItems());
		request.unbind(entity, model, "number");
	}
	


	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;
		
		Quantity result;
		result= new Quantity();
		
		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		
		

	}



	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;	
		
		final int toolkitId;
		toolkitId = request.getModel().getInteger("id");
		final Quantity quantity = new Quantity();
		quantity.setToolkit(this.toolkitRepository.findOneToolkitById(toolkitId));
		this.toolkitRepository.save(entity);
	}

}