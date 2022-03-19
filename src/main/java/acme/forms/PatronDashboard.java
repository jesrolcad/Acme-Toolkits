package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	int totalNumberOfProposedPatronages;
	int totalNumberOfAcceptedPatronages;
	int totalNumberOfDeniedPatronages;
	Map<Pair<String,String>,Double> averageBudgetByCurrency;
	Map<Pair<String,String>,Double> deviationBudgetByCurrency;
	Map<Pair<String,String>,Double> minBudgetByCurrency;
	Map<Pair<String,String>,Double> maxBudgetByCurrency;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}