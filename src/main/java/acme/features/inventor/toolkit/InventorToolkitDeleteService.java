package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorToolkitDeleteService implements AbstractDeleteService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		final boolean result;
		int toolkitId;
		final Toolkit toolkit;
		final Inventor inventor;
		
		toolkitId=request.getModel().getInteger("id");
		toolkit=this.repository.findOneToolkitById(toolkitId);
		inventor=toolkit.getInventor();
		
		result= !toolkit.isPublished() && request.isPrincipal(inventor);
		
		
		return result;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code","title", 
			"description","assemblyNotes", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code","title", 
			"description","assemblyNotes","published", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		int id;
		
		id=request.getModel().getInteger("id");
		result=this.repository.findOneToolkitById(id);
		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		Collection<Quantity> quantitis;
		
		quantitis= this.repository.findQuantityByToolkitId(entity.getId());
		
		
		for(final Quantity quantiti:quantitis) {
			this.repository.delete(quantiti);
		}
		
		this.repository.delete(entity);
	}

}
