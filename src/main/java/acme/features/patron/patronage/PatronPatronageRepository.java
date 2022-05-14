package acme.features.patron.patronage;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron; 
 
@Repository 
public interface PatronPatronageRepository extends AbstractRepository{ 
	 
	@Query("Select p from Patronage p where p.patron.id = :id") 
	Collection<Patronage> findPatronagesByPatronId(int id); 
	@Query("Select p from Patron p where p.userAccount.id = :id")
	Patron findPatronByUserAccountId(int id);
	@Query("Select p from Patronage p where p.id = :id") 
	Patronage findPatronageById(int id); 	
	@Query("Select p from Inventor p where p.id = :id") 
	Inventor findInventorById(int id); 	
	@Query ("select t from Inventor t")
	List<Inventor> allInventors();
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	
	@Query("SELECT p FROM Patronage p WHERE p.code LIKE :code")
	Patronage findPatronageByCode(String code);
	
} 
