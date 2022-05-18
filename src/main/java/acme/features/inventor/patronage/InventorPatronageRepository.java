package acme.features.inventor.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.MoneyExchange;
import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor; 
 
@Repository 
public interface InventorPatronageRepository extends AbstractRepository{ 
	 
	@Query("Select p from Patronage p where p.inventor.id = :id") 
	Collection<Patronage> findPatronagesByInventorId(int id); 
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
	@Query("Select p from Patronage p where p.id = :id") 
	Patronage findPatronageById(int id); 
	
	@Query("select sc.systemCurrency from SystemConfiguration sc")
	String findSystemCurrency();
	
	@Query("select me from MoneyExchange me where me.source.currency = :currency and me.source.amount = :amount")
	MoneyExchange findMoneyExchangeByCurrencyAndAmount(String currency, Double amount);
} 
