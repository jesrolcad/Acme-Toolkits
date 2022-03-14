package acme.features.patron.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository {

	@Query ("select count(p) from Patronage p where p.status = PROPOSED")
	Integer totalNumberOfProposedPatronages();
	@Query ("select count(p) from Patronage p where p.status = ACCEPTED")
	Integer totalNumberOfAccepedPatronages();
	@Query ("select count(p) from Patronage p where p.status = DENIED")
	Integer totalNumberOfDeniedPatronages();
	
	@Query ("select stddev(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Integer deviationPatronageProposedEUR();
	@Query ("select stddev(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Integer deviationPatronageProposedUSD();
	@Query ("select stddev(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Integer deviationPatronageProposedGBP();
	
	@Query ("select stddev(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Integer deviationPatronageAcceptedEUR();
	@Query ("select stddev(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Integer deviationPatronageAcceptedUSD();
	@Query ("select stddev(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Integer deviationPatronageAcceptedGBP();
	
	@Query ("select stddev(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Integer deviationPatronageDeniedEUR();
	@Query ("select stddev(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Integer deviationPatronageDeniedUSD();
	@Query ("select stddev(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Integer deviationPatronageDeniedGBP();
	
	@Query ("select avg(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Integer averagePatronageProposedEUR();
	@Query ("select avg(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Integer averagePatronageProposedUSD();
	@Query ("select avg(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Integer averagePatronageProposedGBP();
	
	@Query ("select avg(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Integer averagePatronageAcceptedEUR();
	@Query ("select avg(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Integer averagePatronageAcceptedUSD();
	@Query ("select avg(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Integer averagePatronageAcceptedGBP();
	
	@Query ("select avg(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Integer averagePatronageDeniedEUR();
	@Query ("select avg(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Integer averagePatronageDeniedUSD();
	@Query ("select avg(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Integer averagePatronageDeniedGBP();
	
	@Query ("select max(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Integer maxPatronageProposedEUR();
	@Query ("select max(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Integer maxPatronageProposedUSD();
	@Query ("select max(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Integer maxPatronageProposedGBP();
	
	@Query ("select max(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Integer maxPatronageAcceptedEUR();
	@Query ("select max(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Integer maxPatronageAcceptedUSD();
	@Query ("select max(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Integer maxPatronageAcceptedGBP();
	
	@Query ("select max(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Integer maxPatronageDeniedEUR();
	@Query ("select max(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Integer maxPatronageDeniedUSD();
	@Query ("select max(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Integer maxPatronageDeniedGBP();
	
	
	@Query ("select min(p) from Patronage p where p.status = PROPOSED and p.budget.currency==EUR")
	Integer minPatronageProposedEUR();
	@Query ("select min(p) from Patronage p where p.status = PROPOSED and p.budget.currency==USD")
	Integer minPatronageProposedUSD();
	@Query ("select min(p) from Patronage p where p.status = PROPOSED and p.budget.currency==GBP")
	Integer minPatronageProposedGBP();
	
	@Query ("select min(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==EUR")
	Integer minPatronageAcceptedEUR();
	@Query ("select min(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==USD")
	Integer minPatronageAcceptedUSD();
	@Query ("select min(p) from Patronage p where p.status = ACCEPTED and p.budget.currency==GBP")
	Integer minPatronageAcceptedGBP();
	
	@Query ("select min(p) from Patronage p where p.status = DENIED and p.budget.currency==EUR")
	Integer minPatronageDeniedEUR();
	@Query ("select min(p) from Patronage p where p.status = DENIED and p.budget.currency==USD")
	Integer minPatronageDeniedUSD();
	@Query ("select min(p) from Patronage p where p.status = DENIED and p.budget.currency==GBP")
	Integer minPatronageDeniedGBP();

//	@Query ("select count(t) from Task t where t.executionPeriodEnd > CURRENT_TIMESTAMP")
//	Integer totalNumberOfNonFinishedTasks();
//	@Query("select avg(datediff(t.executionPeriodEnd,t.executionPeriodInit)) from Task t")
//	Double averageTaskExecutionPeriods();
//	@Query ("select stddev(datediff(t.executionPeriodInit, t.executionPeriodEnd)) from Task t")
//	Double deviationTaskExecutionPeriods();
//
//	@Query ("select min(datediff(t.executionPeriodEnd,t.executionPeriodInit)) from Task t")
//	Double minimumTaskExecutionPeriods();

//	@Query ("select max(datediff(t.executionPeriodEnd,t.executionPeriodInit)) from Task t")
//	Double maximumTaskExecutionPeriods();
//	@Query ("select t from Task t")
//	List<Task> allTasks();
}