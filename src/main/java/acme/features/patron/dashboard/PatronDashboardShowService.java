package acme.features.patron.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class PatronDashboardShowService implements AbstractShowService<Administrator, PatronDashboard> {


	@Autowired
	protected PatronDashboardRepository repository;



	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
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
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;

		PatronDashboard result;
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
		 
		 Integer minPatronageProposedEUR;
		 Integer minPatronageProposedUSD;
		 Integer minPatronageProposedGBP;
		 
		 Integer minPatronageAcceptedEUR;
		 Integer minPatronageAcceptedUSD;
		 Integer minPatronageAcceptedGBP;
		 
		 Integer minPatronageDeniedEUR;
		 Integer minPatronageDeniedUSD;
		 Integer minPatronageDeniedGBP;

		result = new PatronDashboard();

		return result;
	}



}