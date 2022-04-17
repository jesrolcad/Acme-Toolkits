package acme.features.authenticated.announcements;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAnnouncementRepository extends AbstractRepository{
	
	@Query("Select a from Announcement a where a.moment > :fechaLimite")
	Collection<Announcement> findRecentAnnouncement(Date fechaLimite);
	
	@Query("Select a from Announcement a where a.id = :id")
	Announcement findAnnouncementById(int id);
}
