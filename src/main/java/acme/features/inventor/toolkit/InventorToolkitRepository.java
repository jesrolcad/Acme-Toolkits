package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("select i from Toolkit i where i.inventor.id= :id")
	Collection<Toolkit> findManyToolkitsByInventorId(int id);
	
	@Query("select i from Toolkit i where i.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
	
	@Query("select i from Quantity i where i.toolkit.id = :id")
	Collection<Quantity> findQuantityByToolkitId(int id);
	
	@Query("Select q.item from Quantity q where q.id = :id")
	 Collection<Item> findManyItemByQuantityId(int id);
	
	@Query("select sc.systemCurrency from SystemConfiguration sc")
	String findSystemCurrency();

 
}
