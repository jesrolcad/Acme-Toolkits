package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorToolkitItemListService implements AbstractListService<Inventor, Quantity>{
	
	@Autowired
	protected InventorToolkitRepository repository;
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		boolean res=false;
		int id;
		int inventorId;
		int userId;
		id=request.getModel().getInteger("masterId");
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
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		final int toolkitId;
		toolkitId = request.getModel().getInteger("masterId");
		final Collection<Quantity> quantities = this.repository.findQuantityByToolkitId(toolkitId);
		
		return quantities;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Collection<Quantity> entities, final Model model) {
		assert request != null; 
		assert !CollectionHelper.someNull(entities); 
		assert model != null; 
		
		int masterId;
		final Toolkit toolkit;
		
		masterId = request.getModel().getInteger("masterId");
		
		toolkit = this.repository.findOneToolkitById(masterId);
		
		final boolean showCreate = (!toolkit.isPublished() && request.isPrincipal(toolkit.getInventor()));
		
		model.setAttribute("masterId", masterId);
		model.setAttribute("showCreate", showCreate);
		 
	}
	
	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
 
		request.unbind(entity, model, "number", "item.tipo", "item.name", "item.retailPrice"); 
		 
	}

}
