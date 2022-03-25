package acme.features.authenticated.tool;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedToolRepository extends AbstractRepository{
	
	
	@Query("select i from Item i where i.tipo = 1")
	Collection<Item> findMany();

	@Query("select i from Item i where i.tipo = 1 and i.id = :id")
	Item findOneToolById(int id);

}
