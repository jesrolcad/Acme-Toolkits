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
	 Double averageComponentsRetailPriceEUR;
	 Double averageComponentsRetailPriceGBP;
	 Double averageComponentsRetailPriceUSD;
	 Double deviationComponentsRetailPriceEUR;
	 Double deviationComponentsRetailPriceGBP;
	 Double deviationComponentsRetailPriceUSD;
	 Double maxComponentsRetailPriceEUR;
	 Double maxComponentsRetailPriceGBP;
	 Double maxComponentsRetailPriceUSD;
	 Double minComponentsRetailPriceEUR;
	 Double minComponentsRetailPriceGBP;
	 Double minComponentsRetailPriceUSD;
	 
	 
	 Double totalNumberOfTools;
	 Double averageToolsRetailPriceEUR;
	 Double averageToolsRetailPriceGBP;
	 Double averageToolsRetailPriceUSD;
	 Double deviationToolsRetailPriceEUR;
	 Double deviationToolsRetailPriceGBP;
	 Double deviationToolsRetailPriceUSD;
	 Double maxToolsRetailPriceEUR;
	 Double maxToolsRetailPriceGBP;
	 Double maxToolsRetailPriceUSD;
	 Double minCToolsRetailPriceEUR;
	 Double minToolsRetailPriceGBP;
	 Double minToolsRetailPriceUSD;
	 
	 Double totalNumberOfProposedPatronages;
	 Double totalNumberOfAccepedPatronages;
	 Double totalNumberOfDeniedPatronages;
	 
	 Double deviationBudgetPatronageProposed;
	 Double deviationBudgetPatronageAccepted;
	 Double deviationBudgetPatronageDenied;
	 
	 Double averageBudgetPatronageProposed;
	 Double averageBudgetPatronageAccepted;
	 Double averageBudgetPatronageDenied;
	 
	 Double maxBudgetPatronageProposed;
	 Double maxBudgetPatronageAccepted;
	 Double maxBudgetPatronageDenied;
	 
	 Double minBudgetPatronageProposed;
	 Double minBudgetPatronageAccepted;
	 Double minBudgetPatronageDenied;
}

