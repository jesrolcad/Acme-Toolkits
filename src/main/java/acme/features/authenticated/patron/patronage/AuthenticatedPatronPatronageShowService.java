package acme.features.authenticated.patron.patronage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService; 
 
@Service 
public class AuthenticatedPatronPatronageShowService implements AbstractShowService<Authenticated, Patronage>{ 
	 
	 
	@Autowired 
	protected AuthenticatedPatronPatronageRepository repository; 
	
	@Override 
	public boolean authorise(final Request<Patronage> request) { 
		assert request != null; 
		return true; 
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
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		 
		request.unbind(entity, model, "code", "budget", "legalStuff", "link", "startDate","endDate","status","inventor.company","inventor.link","inventor.statement");	 
		model.setAttribute("confirmation", false); 
		model.setAttribute("readonly", true); 
	} 
 
} 