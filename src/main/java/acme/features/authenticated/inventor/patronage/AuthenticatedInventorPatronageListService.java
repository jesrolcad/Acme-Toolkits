package acme.features.authenticated.inventor.patronage;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService; 
 
@Service 
public class AuthenticatedInventorPatronageListService implements AbstractListService<Authenticated, Patronage> { 
	 
	@Autowired 
	protected AuthenticatedInventorPatronageRepository repository; 
 
	@Override 
	public boolean authorise(final Request<Patronage> request) { 
		assert request != null; 
		return true; 
	} 
 
	@Override 
	public Collection<Patronage> findMany(final Request<Patronage> request) { 
		assert request != null; 
		 
		final Collection<Patronage> result; 
		final int UAId = request.getPrincipal().getAccountId();
		final int InventorId = this.repository.findInventorByUserAccountId(UAId).getId();
		result=this.repository.findPatronagesByInventorId(InventorId); 
		
		return result;
	} 
 
	@Override 
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		request.unbind(entity, model, "code","budget.amount", "budget.currency", "legalStuff", "link", "startDate","endDate","status","patron_id");		 
	} 
 
} 
