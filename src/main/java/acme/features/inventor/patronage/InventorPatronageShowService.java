package acme.features.inventor.patronage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor; 
 
@Service 
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage>{ 
	 
	 
	@Autowired 
	protected InventorPatronageRepository repository; 
	
	@Override 
	public boolean authorise(final Request<Patronage> request) { 
		assert request != null;
		boolean result;
		int patronageID;
		Inventor inv;
		Patronage pat;
		
		patronageID = request.getModel().getInteger("id");
		pat = this.repository.findPatronageById(patronageID);
		inv =this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		result = pat.getInventor().equals(inv);
		return result; 
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
		 
		request.unbind(entity, model, "code", "budget", "legalStuff", "link", "startDate","endDate","status","patron.userAccount.username","patron.company","patron.link","patron.statement");	 
		model.setAttribute("confirmation", false); 
		
	} 
 
} 
