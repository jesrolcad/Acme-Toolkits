package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.Quantity;
import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository{
		
		@Query("select t from Toolkit t where t.published = :published")
		Collection<Toolkit> findManyPublishedToolkits(boolean published);

		@Query("select q.item from Quantity q where q.toolkit.id = :toolkitId")
		Collection<Item> findManyItemsByToolkitId(int toolkitId);

		@Query("select t from Toolkit t where t.id = :id")
		Toolkit findOneToolkitById(int id);
		
		@Query("select q from Quantity q where q.toolkit.id = :id")
		Collection<Quantity> findQuantityByToolkitId(int id);
		
		@Query("Select q.item from Quantity q where q.id = :id")
		 Collection<Item> findManyItemByQuantityId(int id);
		
		@Query("select sc.systemCurrency from SystemConfiguration sc")
		String findSystemCurrency();
}


