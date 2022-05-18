	package acme.features.inventor.patronagereport;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
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
	@Query ("select t from PatronageReport t")
	List<PatronageReport> allPatronagesReport();
	@Query("select count(p) from PatronageReport p where p.patronage.code = :code")
	int totalNumberPatronagesWithSameCode(String code);
	@Query("Select p from Patronage p where p.id = :id") 
	Patronage findPatronageById(int id); 
} 
