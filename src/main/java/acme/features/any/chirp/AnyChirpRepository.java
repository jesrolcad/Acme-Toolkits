package acme.features.any.chirp; 
 
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Chirp;
import acme.framework.repositories.AbstractRepository; 
 
@Repository 
public interface AnyChirpRepository extends AbstractRepository{ 
	 
	@Query("Select c from Chirp c where c.moment > ?1") 
	Collection<Chirp> findRecentChirp(Date fechaLimite); 
	 
	@Query("Select c from Chirp c where c.id = :id") 
	Chirp findChirpById(int id); 
	
	
} 

