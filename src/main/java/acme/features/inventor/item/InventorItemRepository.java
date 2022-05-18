package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor; 
 
@Repository 
public interface InventorItemRepository extends AbstractRepository{ 
	 
	@Query("select i from Item i where i.inventor.id = :id")
	Collection<Item> findManyItemsByInventorId(int id);
	 
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
	
	@Query("select i from Item i where i.id = :id")
	Item findItemById(int id);
	
	@Query("select i from Item i where i.code = :code")
	Item findOneItemByCode(String code);
	
	@Query("select sc.acceptedCurrencies from SystemConfiguration sc")
	String findAcceptedCurrencies();
	
	@Query("select i from Item i")
	Collection<Item> findManyItems();
	
	@Query("select i from Item i where i.published = true and i not in (select q.item from Quantity q where q.toolkit.id = :toolkitId)")
	Collection<Item> findAssignableItemsToToolkit(int toolkitId);
} 