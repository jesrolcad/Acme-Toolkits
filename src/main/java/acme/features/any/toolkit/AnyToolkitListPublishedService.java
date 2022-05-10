package acme.features.any.toolkit;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyToolkitListPublishedService implements AbstractListService<Any, Toolkit> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolkitRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Toolkit> findMany(final Request<Toolkit> request) {
		
		assert request != null;

		Collection<Toolkit> result;

		result = this.repository.findManyPublishedToolkits(true);

		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String payload;
		final StringBuilder bufferName = new StringBuilder();
		final StringBuilder bufferCode = new StringBuilder();
		final StringBuilder bufferDescription = new StringBuilder();
		final StringBuilder bufferTechnology = new StringBuilder();
		
		final int toolkitId = entity.getId(); 
		final Collection<Item> items = this.repository.findManyItemsByToolkitId(toolkitId);
		
		int size = items.size(); 
		
		for(final Item i: items) {
			bufferName.append(i.getName());
			bufferCode.append(i.getCode());
			bufferDescription.append(i.getDescription());
			bufferTechnology.append(i.getTechnology());
			
			if(size > 1) {
				bufferName.append(",");
				bufferCode.append(",");
				bufferDescription.append(",");
				bufferTechnology.append(",");
				
				size--;
			}	
		}
		
		payload = String.format(//
			"%s; %s; %s; %s", //
			bufferName.toString(),bufferCode.toString(),bufferDescription.toString(),bufferTechnology.toString());
	
		request.unbind(entity, model, "code", 
			"description","assemblyNotes", "optionalLink", 
			"published", "retailPrice");
		
		model.setAttribute("payload", payload);
		
		
		
		
	}

}