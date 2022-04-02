package acme.features.authenticated.patron.patronage;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron; 
 
@Repository 
public interface AuthenticatedPatronPatronageRepository extends AbstractRepository{ 
	 
	@Query("Select p from Patronage p where p.patron.id = :id") 
	Collection<Patronage> findPatronagesByPatronId(int id); 
	@Query("Select p from Patron p where p.userAccount.id = :id")
	Patron findPatronByUserAccountId(int id);
	@Query("Select p from Patronage p where p.id = :id") 
	Patronage findPatronageById(int id); 
} 
