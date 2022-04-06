package acme.features.anonymous.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.tipo = 1")
	Collection<Item> findManyTools();
	
	@Query("select i from Item i where i.tipo = 0")
	Collection<Item> findManyComponents();

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

}
