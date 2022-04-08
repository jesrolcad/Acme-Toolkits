package acme.features.patron.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;
@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {

	@Autowired
	protected PatronDashboardRepository repository;


	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {

		assert request != null;
		final PatronDashboard result=new PatronDashboard();
		final int totalNumberOfProposedPatronages=this.repository.totalNumberOfProposedPatronages();
		final int totalNumberOfAcceptedPatronages=this.repository.totalNumberOfAcceptedPatronages();
		final int totalNumberOfDeniedPatronages=this.repository.totalNumberOfDeniedPatronages();
		final Map<Pair<String, String>, Double> averageBudgetByCurrency = new HashMap<Pair<String, String>, Double>();
		final Map<Pair<String, String>, Double> deviationBudgetByCurrency = new HashMap<Pair<String, String>, Double>();
		final Map<Pair<String, String>, Double> minBudgetByCurrency = new HashMap<Pair<String, String>, Double>();
		final Map<Pair<String, String>, Double> maxBudgetByCurrency = new HashMap<Pair<String, String>, Double>();

		int i=0;
	
		while(i<this.repository.averageBudgetByCurrency().size()) {
			final String linea= this.repository.averageBudgetByCurrency().get(i);
			final String[] sub=linea.split(",");
			final Double key=Double.parseDouble(sub[1]);
			final String divisa=sub[0];
			final String estado= sub[2];
			final Pair<String, String> res=Pair.of(divisa, estado);
			averageBudgetByCurrency.put(res, key);
			i++;
		}
		i=0;
		while(i<this.repository.deviationBudgetByCurrency().size()) {
			final String linea= this.repository.deviationBudgetByCurrency().get(i);
			final String[] sub=linea.split(",");
			final Double key=Double.parseDouble(sub[1]);
			final String divisa=sub[0];
			final String estado= sub[2];
			final Pair<String, String> res=Pair.of(divisa, estado);
			deviationBudgetByCurrency.put(res, key);
			i++;
		}
		i=0;
		while(i<this.repository.minBudgetByCurrency().size()) {
			final String linea= this.repository.minBudgetByCurrency().get(i);
			final String[] sub=linea.split(",");
			final Double key=Double.parseDouble(sub[1]);
			final String divisa=sub[0];
			final String estado= sub[2];
			final Pair<String, String> res=Pair.of(divisa, estado);
			minBudgetByCurrency.put(res, key);
			i++;
		}
		i=0;
		while(i<this.repository.maxBudgetByCurrency().size()) {
			final String linea= this.repository.maxBudgetByCurrency().get(i);
			final String[] sub=linea.split(",");
			final Double key=Double.parseDouble(sub[1]);
			final String divisa=sub[0];
			final String estado= sub[2];
			final Pair<String, String> res=Pair.of(divisa, estado);
			maxBudgetByCurrency.put(res, key);
			i++;
		}
		result.setTotalNumberOfAcceptedPatronages(totalNumberOfAcceptedPatronages);
		result.setTotalNumberOfProposedPatronages(totalNumberOfProposedPatronages);
		result.setTotalNumberOfDeniedPatronages(totalNumberOfDeniedPatronages);
		result.setAverageBudgetByCurrency(averageBudgetByCurrency);
		result.setDeviationBudgetByCurrency(deviationBudgetByCurrency);
		result.setMinBudgetByCurrency(minBudgetByCurrency);
		result.setMaxBudgetByCurrency(maxBudgetByCurrency);

		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfProposedPatronages", "totalNumberOfAcceptedPatronages", "totalNumberOfDeniedPatronages", "averageBudgetByCurrency", "deviationBudgetByCurrency", "minBudgetByCurrency", "maxBudgetByCurrency");
	}

}
