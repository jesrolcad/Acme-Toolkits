package acme.testing.any.chirp;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Chirp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ChirpRepository extends AbstractRepository{

	@Query("select c from Chirp c where c.moment between '1900/01/01' and '1900/01/31'")
	Collection<Chirp> findChirpsToPatch();

}
