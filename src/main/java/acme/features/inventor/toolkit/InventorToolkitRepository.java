package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("select i from Toolkit i")
	Collection<Toolkit> findManyToolkits();
	
	@Query("select i from Toolkit i where i.id = :id")
	Toolkit findOneToolkitById(int id);


}
