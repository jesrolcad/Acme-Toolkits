package acme.features.patron.patronagereport;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron; 
 
@Repository 
public interface PatronPatronageReportRepository extends AbstractRepository{ 
	 
	@Query("Select p from PatronageReport p where p.patronage.patron.id = :id") 
	Collection<PatronageReport> findPatronageReportsByPatronId(int id); 
	@Query("Select p from Patron p where p.userAccount.id = :id")
	Patron findPatronByUserAccountId(int id);
	@Query("Select p from PatronageReport p where p.id = :id") 
	PatronageReport findPatronageReportById(int id); 
} 
