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
	 
	@Query("Select p from Patronage p where p.inventor.id = :id and p.published = :published and (status = acme.entities.Status.ACCEPTED or status = acme.entities.Status.DENIED)") 
	Collection<Patronage> findPublishedAcceptedOrDeniedPatronagesByInventorId(int id, boolean published); 
	
	@Query("Select p from Patronage p where p.inventor.id = :id and p.published = :published and status = acme.entities.Status.PROPOSED") 
	Collection<Patronage> findPublishedProposedPatronagesByInventorId(int id, boolean published); 
		
	@Query("Select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);
	@Query("Select p from Patronage p where p.id = :id") 
	Patronage findPatronageById(int id); 
	
	@Query("select sc.systemCurrency from SystemConfiguration sc")
	String findSystemCurrency();
	
	@Query("select me from MoneyExchange me where me.source.currency = :currency and me.source.amount = :amount and me.target.currency = :systemCurrency")
	MoneyExchange findMoneyExchangeByCurrencyAndAmount(String currency, Double amount, String systemCurrency);
} 
