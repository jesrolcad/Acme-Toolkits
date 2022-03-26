package acme.features.authenticated.announcements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAnnouncementShowService implements AbstractShowService<Authenticated, Announcement>{
	
	
	@Autowired
	protected AuthenticatedAnnouncementRepository repository;
	// Interfaz
	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}

	@Override
	public Announcement findOne(final Request<Announcement> request) {
		assert request != null;
		
		Announcement result;
		int id;
		
		id=request.getModel().getInteger("id");
		result=this.repository.findAnnouncementById(id);
		return result;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title","moment", "body", "info", "critical");	
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}

}
