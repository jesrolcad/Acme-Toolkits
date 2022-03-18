package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	 Integer totalNumberOfProposedPatronages;
	 Integer totalNumberOfAccepedPatronages;
	 Integer totalNumberOfDeniedPatronages;
	 Double deviationBudgetPatronageProposedEUR;
	 Double deviationBudgetPatronageProposedUSD;
	 Double deviationBudgetPatronageProposedGBP;
	 Double deviationBudgetPatronageAcceptedEUR;
	 Double deviationBudgetPatronageAcceptedUSD;
	 Double deviationBudgetPatronageAcceptedGBP;
	 Double deviationBudgetPatronageDeniedEUR;
	 Double deviationBudgetPatronageDeniedUSD;
	 Double deviationBudgetPatronageDeniedGBP;
	 Double averageBudgetPatronageProposedEUR;
	 Double averageBudgetPatronageProposedUSD;
	 Double averageBudgetPatronageProposedGBP;
	 Double averageBudgetPatronageAcceptedEUR;
	 Double averageBudgetPatronageAcceptedUSD;
	 Double averageBudgetPatronageAcceptedGBP;
	 Double averageBudgetPatronageDeniedEUR;
	 Double averageBudgetPatronageDeniedUSD;
	 Double averageBudgetPatronageDeniedGBP;
	 Double maxBudgetPatronageProposedEUR;
	 Double maxBudgetPatronageProposedUSD;
	 Double maxBudgetPatronageProposedGBP;
	 Double maxBudgetPatronageAcceptedEUR;
	 Double maxBudgetPatronageAcceptedUSD;
	 Double maxBudgetPatronageAcceptedGBP;
	 Double maxBudgetPatronageDeniedEUR;
	 Double maxBudgetPatronageDeniedUSD;
	 Double maxBudgetPatronageDeniedGBP;
	 Double minBudgetPatronageProposedEUR;
	 Double minBudgetPatronageProposedUSD;
	 Double minBudgetPatronageProposedGBP;
	 Double minBudgetPatronageAcceptedEUR;
	 Double minBudgetPatronageAcceptedUSD;
	 Double minBudgetPatronageAcceptedGBP;
	 Double minBudgetPatronageDeniedEUR;
	 Double minBudgetPatronageDeniedUSD;
	 Double minBudgetPatronageDeniedGBP;
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}