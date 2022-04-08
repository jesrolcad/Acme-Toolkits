package acme.features.inventor.patronagereport;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor; 
 
@Repository 
public interface InventorPatronageReportRepository extends AbstractRepository{ 
	 
	@Query("Select p from PatronageReport p where p.patronage.inventor.id = :id") 
	Collection<PatronageReport> findPatronageReportsByInventorId(int id); 
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
	@Query("Select p from PatronageReport p where p.id = :id") 
	PatronageReport findPatronageReportById(int id); 
} 
