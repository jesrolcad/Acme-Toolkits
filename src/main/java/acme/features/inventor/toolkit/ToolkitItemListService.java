package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Quantity;
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
		 
		return true; 
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request) {
		 final Collection<Item> result = new HashSet<Item>();
		int toolkitid;
		System.out.println("Uno");
		toolkitid = request.getModel().getInteger("id");
		System.out.println("dos "+toolkitid);
		final Collection<Quantity> QuantityId = this.repository.findQuantityByToolkitId(toolkitid);
		System.out.println("tres "+ QuantityId);
		
		for(final Quantity quantity: QuantityId) {
			final int id=quantity.getId();
			final Collection<Item> items=this.repository.findManyItemByQuantityId(id);
			result.addAll(items);
		}
		
		System.out.println("ni puta idea entonces "+result.toString());
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		
 
		request.unbind(entity, model, "name","code", "technology", "retailPrice"); 
		 
	}

}
