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

	Map<String, Integer> totalNumberItems;
	Map<Pair<String,String>,Double>averageRetailPriceOfComponents;
	Map<Pair<String,String>,Double>deviationRetailPriceOfComponents;
	Map<Pair<String,String>,Double>minRetailPriceOfComponents;
	Map<Pair<String,String>,Double>maxRetailPriceOfComponents;
	Map<String,Double> averageRetailPriceOfTools;
	Map<String,Double> deviationRetailPriceOfTools;
	Map<String,Double> maxRetailPriceOfTools;
	Map<String,Double> minRetailPriceOfTools;
	Map<String,Integer> totalNumberPatronagesByStatus;
	Map<String,Double> averageBudgetByCurrency;
	Map<String,Double> deviationBudgetByCurrency;
	Map<String,Double> minBudgetByCurrency;
	Map<String,Double> maxBudgetByCurrency;




	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}