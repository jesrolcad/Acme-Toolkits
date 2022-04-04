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
		PatronDashboard result=new PatronDashboard();
		int totalNumberOfProposedPatronages=this.repository.totalNumberOfProposedPatronages();
		int totalNumberOfAcceptedPatronages=this.repository.totalNumberOfAcceptedPatronages();
		int totalNumberOfDeniedPatronages=this.repository.totalNumberOfDeniedPatronages();
		Map<Pair<String, String>, Double> averageBudgetByCurrency = new HashMap<Pair<String, String>, Double>();
		Map<Pair<String, String>, Double> deviationBudgetByCurrency = new HashMap<Pair<String, String>, Double>();
		Map<Pair<String, String>, Double> minBudgetByCurrency = new HashMap<Pair<String, String>, Double>();
		Map<Pair<String, String>, Double> maxBudgetByCurrency = new HashMap<Pair<String, String>, Double>();

		int i=0;
	
		while(i<this.repository.averageBudgetByCurrency().size()) {
			String linea= this.repository.averageBudgetByCurrency().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			String estado= sub[2];
			Pair<String, String> res=Pair.of(divisa, estado);
			averageBudgetByCurrency.put(res, key);
			i++;
		}
		i=0;
		while(i<this.repository.deviationBudgetByCurrency().size()) {
			String linea= this.repository.deviationBudgetByCurrency().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			String estado= sub[2];
			Pair<String, String> res=Pair.of(divisa, estado);
			deviationBudgetByCurrency.put(res, key);
			i++;
		}
		i=0;
		while(i<this.repository.minBudgetByCurrency().size()) {
			String linea= this.repository.minBudgetByCurrency().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			String estado= sub[2];
			Pair<String, String> res=Pair.of(divisa, estado);
			minBudgetByCurrency.put(res, key);
			i++;
		}
		i=0;
		while(i<this.repository.maxBudgetByCurrency().size()) {
			String linea= this.repository.maxBudgetByCurrency().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			String estado= sub[2];
			Pair<String, String> res=Pair.of(divisa, estado);
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
		System.out.println(result.toString());

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
