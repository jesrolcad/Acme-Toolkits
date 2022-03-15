package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronageDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	 Integer totalNumberOfProposedPatronages;
	 Integer totalNumberOfAccepedPatronages;
	 Integer totalNumberOfDeniedPatronages;
	 Integer deviationBudgetPatronageProposedEUR;
	 Integer deviationBudgetPatronageProposedUSD;
	 Integer deviationBudgetPatronageProposedGBP;
	 Integer deviationBudgetPatronageAcceptedEUR;
	 Integer deviationBudgetPatronageAcceptedUSD;
	 Integer deviationBudgetPatronageAcceptedGBP;
	 Integer deviationBudgetPatronageDeniedEUR;
	 Integer deviationBudgetPatronageDeniedUSD;
	 Integer deviationBudgetPatronageDeniedGBP;
	 Integer averageBudgetPatronageProposedEUR;
	 Integer averageBudgetPatronageProposedUSD;
	 Integer averageBudgetPatronageProposedGBP;
	 Integer averageBudgetPatronageAcceptedEUR;
	 Integer averageBudgetPatronageAcceptedUSD;
	 Integer averageBudgetPatronageAcceptedGBP;
	 Integer averageBudgetPatronageDeniedEUR;
	 Integer averageBudgetPatronageDeniedUSD;
	 Integer averageBudgetPatronageDeniedGBP;
	 Integer maxBudgetPatronageProposedEUR;
	 Integer maxBudgetPatronageProposedUSD;
	 Integer maxBudgetPatronageProposedGBP;
	 Integer maxBudgetPatronageAcceptedEUR;
	 Integer maxBudgetPatronageAcceptedUSD;
	 Integer maxBudgetPatronageAcceptedGBP;
	 Integer maxBudgetPatronageDeniedEUR;
	 Integer maxBudgetPatronageDeniedUSD;
	 Integer maxBudgetPatronageDeniedGBP;
	 Integer minBudgetPatronageProposedEUR;
	 Integer minBudgetPatronageProposedUSD;
	 Integer minBudgetPatronageProposedGBP;
	 Integer minBudgetPatronageAcceptedEUR;
	 Integer minBudgetPatronageAcceptedUSD;
	 Integer minBudgetPatronageAcceptedGBP;
	 Integer minBudgetPatronageDeniedEUR;
	 Integer minBudgetPatronageDeniedUSD;
	 Integer minBudgetPatronageDeniedGBP;
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}