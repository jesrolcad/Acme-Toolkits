package acme.features.patronage.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronageDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class PatronageDashboardShowService implements AbstractShowService<Administrator, PatronageDashboard> {


	@Autowired
	protected PatronageDashboardRepository repository;



	@Override
	public boolean authorise(final Request<PatronageDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<PatronageDashboard> request, final PatronageDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfProposedPatronages", "totalNumberOfAccepedPatronages", "totalNumberOfDeniedPatronages",
			"deviationPatronageProposedEUR", "deviationPatronageProposedUSD", "deviationPatronageProposedGBP",
			"deviationPatronageAcceptedEUR", "deviationPatronageAcceptedUSD","deviationPatronageAcceptedGBP",
			"deviationPatronageDeniedEUR", "deviationPatronageDeniedUSD", "deviationPatronageDeniedGBP", 
			
			"averagePatronageProposedEUR", "averagePatronageProposedUSD", "averagePatronageProposedGBP", 
			"averagePatronageAcceptedEUR", "averagePatronageAcceptedUSD","averagePatronageAcceptedGBP", 
			"averagePatronageDeniedEUR", "averagePatronageDeniedUSD", "averagePatronageDeniedGBP", 
			"maxPatronageProposedEUR", "maxPatronageProposedUSD", "maxPatronageProposedGBP", 
			"maxPatronageAcceptedEUR","maxPatronageAcceptedUSD","maxPatronageAcceptedGBP",
			"maxPatronageDeniedEUR", "maxPatronageDeniedUSD", "maxPatronageDeniedGBP", 
			"minPatronageProposedEUR", "minPatronageProposedUSD", "minPatronageProposedGBP", 
			"minPatronageAcceptedEUR","minPatronageAcceptedEUR","minPatronageAcceptedEUR", 
			"minPatronageDeniedEUR", "minPatronageDeniedUSD", "minPatronageDeniedGBP");
	}

	@Override
	public PatronageDashboard findOne(final Request<PatronageDashboard> request) {
		assert request != null;

		PatronageDashboard result;
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

		result = new PatronageDashboard();

		return result;
	}



}