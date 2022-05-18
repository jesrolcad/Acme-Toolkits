package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.TipoDeItem;
import acme.entities.Toolkit;
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
		
		boolean result;
		int masterId;
		Toolkit toolkit;

		masterId = request.getModel().getInteger("masterId");
		toolkit = this.toolkitRepository.findOneToolkitById(masterId);
		result = (toolkit != null && !toolkit.isPublished() && request.isPrincipal(toolkit.getInventor()));
		return result;
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

			entity.setItem(this.itemRepository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
			request.bind(entity, errors, "number","itemId");
			
	}	
	


	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {

		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		final int masterId = Integer.valueOf((String) request.getModel().getAttribute("masterId"));
		model.setAttribute("masterId", masterId);
		model.setAttribute("items", this.itemRepository.findAssignableItemsToToolkit(masterId));
		request.unbind(entity, model, "number");
	}
	


	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;
		
		Quantity result;
		result= new Quantity();
		
		final Toolkit toolkit = this.toolkitRepository.findOneToolkitById(request.getModel().getInteger("masterId"));
		
		result.setToolkit(toolkit);
		
		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		// Una toolkit no puede tener más de una tool asociada
		if(!errors.hasErrors("items")) {
			final Item selectedItem = this.itemRepository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString()));
			if(selectedItem.getTipo().equals(TipoDeItem.TOOL)) {
				final Integer numTools = this.toolkitRepository.findNumToolsOfToolkit(entity.getToolkit().getId());
				errors.state(request, numTools == 0, "*", "inventor.quantity.form.error.toolkit-has-tool");
			}
			
			
		}
		
		// Si un item ya ha sido elegido en el selector, entonces no se puede añadir más (eso se haría en el update service)
		

	}



	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;	

		
		this.toolkitRepository.save(entity);
	}

}