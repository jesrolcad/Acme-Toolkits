package acme.features.authenticated.announcements;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAnnouncementListRecentService implements AbstractListService<Authenticated, Announcement> {
	
	@Autowired
	protected AuthenticatedAnnouncementRepository repository;

	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;
		
		final Collection<Announcement> result;
		Calendar calendar;
		Date fechaLimite;
		
		calendar=Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		fechaLimite=calendar.getTime();
		
		result=this.repository.findRecentAnnouncement(fechaLimite);
		
		return result;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title","moment", "body", "info", "critical");		
	}

}
