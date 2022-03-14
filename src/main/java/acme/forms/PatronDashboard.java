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
	 Integer deviationPatronageProposedEUR;
	 Integer deviationPatronageProposedUSD;
	 Integer deviationPatronageProposedGBP;
	 Integer deviationPatronageAcceptedEUR;
	 Integer deviationPatronageAcceptedUSD;
	 Integer deviationPatronageAcceptedGBP;
	 Integer deviationPatronageDeniedEUR;
	 Integer deviationPatronageDeniedUSD;
	 Integer deviationPatronageDeniedGBP;
	 Integer averagePatronageProposedEUR;
	 Integer averagePatronageProposedUSD;
	 Integer averagePatronageProposedGBP;
	 Integer averagePatronageAcceptedEUR;
	 Integer averagePatronageAcceptedUSD;
	 Integer averagePatronageAcceptedGBP;
	 Integer averagePatronageDeniedEUR;
	 Integer averagePatronageDeniedUSD;
	 Integer averagePatronageDeniedGBP;
	 Integer maxPatronageProposedEUR;
	 Integer maxPatronageProposedUSD;
	 Integer maxPatronageProposedGBP;
	 Integer maxPatronageAcceptedEUR;
	 Integer maxPatronageAcceptedUSD;
	 Integer maxPatronageAcceptedGBP;
	 Integer maxPatronageDeniedEUR;
	 Integer maxPatronageDeniedUSD;
	 Integer maxPatronageDeniedGBP;
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}