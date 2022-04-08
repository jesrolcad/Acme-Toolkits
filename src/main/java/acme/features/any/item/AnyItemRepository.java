package acme.features.any.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.tipo = 1 and i.published = 1")
	Collection<Item> findManyPublishedTools();
	
	@Query("select i from Item i where i.tipo = 0 and i.published = 1")
	Collection<Item> findManyPublishedComponents();

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

}
