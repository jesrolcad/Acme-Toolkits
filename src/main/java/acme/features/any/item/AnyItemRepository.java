package acme.features.any.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.MoneyExchange;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository{
	

	@Query("select i from Item i where i.published = :published")
	Collection<Item> findManyPublishedItems(boolean published);

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select sc.systemCurrency from SystemConfiguration sc")
	String findSystemCurrency();
	
	@Query("select me from MoneyExchange me where me.source.currency = :currency and me.source.amount = :amount")
	MoneyExchange findMoneyExchangeByCurrencyAndAmount(String currency, Double amount);
}
