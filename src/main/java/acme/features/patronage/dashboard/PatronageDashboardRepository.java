package acme.features.patronage.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronageDashboardRepository extends AbstractRepository {

	@Query ("select count(p) from Patronage p where p.status = PROPOSED")
	Double totalNumberOfProposedPatronages();
	@Query ("select count(p) from Patronage p where p.status = ACCEPTED")
	Double totalNumberOfAccepedPatronages();
	@Query ("select count(p) from Patronage p where p.status = DENIED")
	Double totalNumberOfDeniedPatronages();
	
	@Query ("select stddev(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Double deviationPatronageProposedEUR();
	@Query ("select stddev(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Double deviationPatronageProposedUSD();
	@Query ("select stddev(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Double deviationPatronageProposedGBP();
	
	@Query ("select stddev(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Double deviationPatronageAcceptedEUR();
	@Query ("select stddev(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Double deviationPatronageAcceptedUSD();
	@Query ("select stddev(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Double deviationPatronageAcceptedGBP();
	
	@Query ("select stddev(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Double deviationPatronageDeniedEUR();
	@Query ("select stddev(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Double deviationPatronageDeniedUSD();
	@Query ("select stddev(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Double deviationPatronageDeniedGBP();
	
	@Query ("select avg(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Double averagePatronageProposedEUR();
	@Query ("select avg(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Double averagePatronageProposedUSD();
	@Query ("select avg(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Double averagePatronageProposedGBP();
	
	@Query ("select avg(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Double averagePatronageAcceptedEUR();
	@Query ("select avg(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Double averagePatronageAcceptedUSD();
	@Query ("select avg(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Double averagePatronageAcceptedGBP();
	
	@Query ("select avg(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Double averagePatronageDeniedEUR();
	@Query ("select avg(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Double averagePatronageDeniedUSD();
	@Query ("select avg(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Double averagePatronageDeniedGBP();
	
	@Query ("select max(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Double maxPatronageProposedEUR();
	@Query ("select max(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Double maxPatronageProposedUSD();
	@Query ("select max(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Double maxPatronageProposedGBP();
	
	@Query ("select max(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Double maxPatronageAcceptedEUR();
	@Query ("select max(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Double maxPatronageAcceptedUSD();
	@Query ("select max(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Double maxPatronageAcceptedGBP();
	
	@Query ("select max(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Double maxPatronageDeniedEUR();
	@Query ("select max(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Double maxPatronageDeniedUSD();
	@Query ("select max(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Double maxPatronageDeniedGBP();
	
	
	@Query ("select min(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Double minPatronageProposedEUR();
	@Query ("select min(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Double minPatronageProposedUSD();
	@Query ("select min(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Double minPatronageProposedGBP();
	
	@Query ("select min(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Double minPatronageAcceptedEUR();
	@Query ("select min(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Double minPatronageAcceptedUSD();
	@Query ("select min(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Double minPatronageAcceptedGBP();
	
	@Query ("select min(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Double minPatronageDeniedEUR();
	@Query ("select min(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Double minPatronageDeniedUSD();
	@Query ("select min(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Double minPatronageDeniedGBP();

 
}