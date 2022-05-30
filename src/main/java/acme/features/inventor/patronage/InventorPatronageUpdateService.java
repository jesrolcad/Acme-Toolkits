package acme.features.inventor.patronage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor; 
 
@Service 
public class InventorPatronageUpdateService implements AbstractUpdateService<Inventor, Patronage>{ 
 
	@Autowired 
	protected InventorPatronageRepository repository; 
	  
	@Override 
	public boolean authorise(final Request<Patronage> request) { 
		assert request != null; 
		 
		final boolean result;
		int patronageId;
		final Patronage patronage; 
		final Inventor inventor; 
		
		patronageId=request.getModel().getInteger("id");
		patronage=this.repository.findPatronageById(patronageId); 
		inventor=patronage.getInventor(); 
		 
		result= request.isPrincipal(inventor) && patronage.isPublished() && patronage.getStatus().equals(Status.PROPOSED);
		 
		 
		return result; 
	} 
 
	@Override 
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) { 
		assert request != null; 
		assert entity != null; 
		assert errors != null; 
		request.bind(entity, errors,"code", "budget", "legalStuff", "link", "startDate","endDate","status","patron.userAccount.username","patron.company","patron.link","patron.statement"); 
		 
	} 
 
	@Override 
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		request.unbind(entity, model,"code", "budget", "legalStuff", "link", "startDate","endDate","status","patron.userAccount.username","patron.company","patron.link","patron.statement"); 
		model.setAttribute("confirmation", false); 
	} 
 
	@Override 
	public Patronage findOne(final Request<Patronage> request) { 
		assert request != null; 
		 
		Patronage result; 
		int id; 
		 
		id=request.getModel().getInteger("id"); 
		result=this.repository.findPatronageById(id); 
		return result; 
	} 
 
	@Override 
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) { 
		
		assert request != null; 
		assert entity != null; 
		assert errors != null; 
		 
	} 
 
	@Override 
	public void update(final Request<Patronage> request, final Patronage entity) { 
		assert request != null; 
		assert entity != null;
		this.repository.save(entity); 
		 
	} 
 
} 
