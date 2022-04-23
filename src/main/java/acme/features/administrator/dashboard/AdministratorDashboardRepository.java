package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;


public interface AdministratorDashboardRepository extends AbstractRepository {
	@Query("select count(p) from Patronage p where p.status = acme.entities.Status.PROPOSED")
	int totalNumberOfProposedPatronages();
	@Query("select count(p) from Patronage p where p.status = acme.entities.Status.ACCEPTED")
	int totalNumberOfAcceptedPatronages();
	@Query("select count(p) from Patronage p where p.status = acme.entities.Status.DENIED")
	int totalNumberOfDeniedPatronages();
	@Query("select count(i) from Item i where i.tipo = acme.entities.TipoDeItem.TOOL")
	int totalNumberOfTools();	
	@Query("select count(i) from Item i where i.tipo = acme.entities.TipoDeItem.COMPONENT")
	int totalNumberOfComponents();	

	@Query("select i.retailPrice.currency, i.technology, avg(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.COMPONENT group by i.retailPrice.currency, i.technology")
	List<String> averageRetailPriceOfComponents();
	@Query("select i.retailPrice.currency, i.technology, stddev(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.COMPONENT group by i.retailPrice.currency, i.technology")
	List<String> deviationRetailPriceOfComponents();
	@Query("select i.retailPrice.currency, i.technology, min(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.COMPONENT group by i.retailPrice.currency, i.technology")
	List<String> minRetailPriceOfComponents();
	@Query("select i.retailPrice.currency, i.technology, max(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.COMPONENT group by i.retailPrice.currency, i.technology")
	List<String> maxRetailPriceOfComponents();
	
	@Query("select i.retailPrice.currency, avg(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.TOOL group by i.retailPrice.currency")
	List<String> averageRetailPriceOfTools();
	@Query("select i.retailPrice.currency, stddev(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.TOOL group by i.retailPrice.currency")
	List<String> deviationRetailPriceOfTools();
	@Query("select i.retailPrice.currency, min(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.TOOL group by i.retailPrice.currency")
	List<String> minRetailPriceOfTools();
	@Query("select i.retailPrice.currency, min(i.retailPrice.amount), i.tipo from Item i where i.tipo=acme.entities.TipoDeItem.TOOL group by i.retailPrice.currency")
	List<String> maxRetailPriceOfTools();
	
	@Query("select p.budget.currency, avg(p.budget.amount), p.status from Patronage p group by p.status")
	List<String> averageBudgetByStatus();
	@Query("select p.budget.currency, stddev(p.budget.amount), p.status from Patronage p group by p.status")
	List<String> deviationBudgetByStatus();
	@Query("select p.budget.currency, min(p.budget.amount), p.status from Patronage p group by p.status")
	List<String> minBudgetByStatus();
	@Query("select p.budget.currency, min(p.budget.amount), p.status from Patronage p group by p.status")
	List<String> maxBudgetByStatus();
	//Map<String,Double> averageBudgetByStatus;

	
}
