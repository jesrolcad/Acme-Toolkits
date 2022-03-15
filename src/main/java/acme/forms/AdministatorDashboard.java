package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministatorDashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

	 Integer totalNumberOfComponents;
	 Integer averageComponentsRetailPriceEUR;
	 Integer averageComponentsRetailPriceGBP;
	 Integer averageComponentsRetailPriceUSD;
	 Integer deviationComponentsRetailPriceEUR;
	 Integer deviationComponentsRetailPriceGBP;
	 Integer deviationComponentsRetailPriceUSD;
	 Integer maxComponentsRetailPriceEUR;
	 Integer maxComponentsRetailPriceGBP;
	 Integer maxComponentsRetailPriceUSD;
	 Integer minComponentsRetailPriceEUR;
	 Integer minComponentsRetailPriceGBP;
	 Integer minComponentsRetailPriceUSD;
	 
	 
	 Integer totalNumberOfTools;
	 Integer averageToolsRetailPriceEUR;
	 Integer averageToolsRetailPriceGBP;
	 Integer averageToolsRetailPriceUSD;
	 Integer deviationToolsRetailPriceEUR;
	 Integer deviationToolsRetailPriceGBP;
	 Integer deviationToolsRetailPriceUSD;
	 Integer maxToolsRetailPriceEUR;
	 Integer maxToolsRetailPriceGBP;
	 Integer maxToolsRetailPriceUSD;
	 Integer minCToolsRetailPriceEUR;
	 Integer minToolsRetailPriceGBP;
	 Integer minToolsRetailPriceUSD;
	 
	 Integer totalNumberOfProposedPatronages;
	 Integer totalNumberOfAccepedPatronages;
	 Integer totalNumberOfDeniedPatronages;
	 
	 Integer deviationBudgetPatronageProposed;
	 Integer deviationBudgetPatronageAccepted;
	 Integer deviationBudgetPatronageDenied;
	 
	 Integer averageBudgetPatronageProposed;
	 Integer averageBudgetPatronageAccepted;
	 Integer averageBudgetPatronageDenied;
	 
	 Integer maxBudgetPatronageProposed;
	 Integer maxBudgetPatronageAccepted;
	 Integer maxBudgetPatronageDenied;
	 
	 Integer minBudgetPatronageProposed;
	 Integer minBudgetPatronageAccepted;
	 Integer minBudgetPatronageDenied;
}

