package acme.features.authenticated.patronage;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface AuthenticatedPatronageRepository extends AbstractRepository {

	@Query("select p from Patronage p where p.patronId.id = :id")
	Patronage findOnePatronageByPatronId(int id);

	@Query("select p from Patron p where p.id= :id")
	Patron findOnePatronById(int id);
	
	@Query("select p from Patronage p where p.inventorId.id = :id")
	Patronage findOnePatronageByInventorId(int id);

}
