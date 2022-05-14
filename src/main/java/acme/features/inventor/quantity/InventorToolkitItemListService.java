package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
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
	public Collection<Quantity> findMany(final Request<Quantity> request) {
//		final Collection<Item> result = new HashSet<Item>();
		final int toolkitId;
		toolkitId = request.getModel().getInteger("id");
		final Collection<Quantity> quantities = this.repository.findQuantityByToolkitId(toolkitId);
		
		
//		for(final Quantity quantity: quantities) {
//			final int id=quantity.getId();
//			final Collection<Item> items=this.repository.findManyItemByQuantityId(id);
//			result.addAll(items);
//		}
//		
		return quantities;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
 
		request.unbind(entity, model, "number", "item.tipo", "item.name","item.code", "item.technology", "item.retailPrice"); 
		 
	}

}
