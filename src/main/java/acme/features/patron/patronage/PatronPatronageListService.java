package acme.features.patron.patronage;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron; 
 
@Service 
public class PatronPatronageListService implements AbstractListService<Patron, Patronage> { 
	 
	@Autowired 
	protected PatronPatronageRepository repository; 
 
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
		final int PatronId = this.repository.findPatronByUserAccountId(UAId).getId();
		result=this.repository.findPatronagesByPatronId(PatronId); 
		
		return result;
	} 
 
	@Override 
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		request.unbind(entity, model, "code","budget","legalStuff", "link", "startDate","endDate","status");		 
	} 
 
} 
