package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository{
	
	@Query("select i from Item i where i.tipo = 1 and i.inventor.id = :id")
	Collection<Item> findManyToolsByInventorId(int id);
	 
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
 
	@Query("select i from Item i where i.tipo = 0 and i.inventor.id = :id")
	Collection<Item> findManyComponentsByInventorId(int id);
	 
	@Query("select i from Item i where i.id = :id")
	Item findItemlById(int id);

}
