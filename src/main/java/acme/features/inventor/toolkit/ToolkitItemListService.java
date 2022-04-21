package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service 
public class ToolkitItemListService implements AbstractListService<Inventor, Item>{
	
	@Autowired
	protected InventorToolkitRepository repository;
	@Override
	public boolean authorise(final Request<Item> request) {
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
	public Collection<Item> findMany(final Request<Item> request) {
		 final Collection<Item> result = new HashSet<Item>();
		int toolkitid;
		toolkitid = request.getModel().getInteger("id");
		final Collection<Quantity> quantities = this.repository.findQuantityByToolkitId(toolkitid);
		
		
		for(final Quantity quantity: quantities) {
			final int id=quantity.getId();
			final Collection<Item> items=this.repository.findManyItemByQuantityId(id);
			result.addAll(items);
		}
		
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		
 
		request.unbind(entity, model, "tipo", "name","code", "technology", "retailPrice"); 
		 
	}

}
