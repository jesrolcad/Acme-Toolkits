package acme.features.administrator.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard>{
	@Autowired
	protected AdministratorDashboardRepository repository;

	@Override
	public boolean authorise(Request<AdministratorDashboard> request) {
		assert request != null;
		return true;
	}


	@Override
	public AdministratorDashboard findOne(Request<AdministratorDashboard> request) {
		assert request != null;
		AdministratorDashboard result=new AdministratorDashboard();
		int totalNumberOfProposedPatronages=this.repository.totalNumberOfProposedPatronages();
		int totalNumberOfAcceptedPatronages=this.repository.totalNumberOfAcceptedPatronages();
		int totalNumberOfDeniedPatronages=this.repository.totalNumberOfDeniedPatronages();	
		int totalNumberOfTools= this.repository.totalNumberOfTools();
		int totalNumberOfComponents= this.repository.totalNumberOfComponents();
		Map<Pair<String, String>, Double> averageRetailPriceOfComponents =  new HashMap<Pair<String, String>, Double>();	
		Map<Pair<String, String>, Double> deviationRetailPriceOfComponents =  new HashMap<Pair<String, String>, Double>();		
		Map<Pair<String, String>, Double> minRetailPriceOfComponents =  new HashMap<Pair<String, String>, Double>();		
		Map<Pair<String, String>, Double> maxRetailPriceOfComponents =  new HashMap<Pair<String, String>, Double>();		
		Map<String,Double> averageRetailPriceOfTools= new HashMap<String, Double>();
		Map<String,Double> deviationRetailPriceOfTools= new HashMap<String, Double>();
		Map<String,Double> minRetailPriceOfTools= new HashMap<String, Double>();
		Map<String,Double> maxRetailPriceOfTools= new HashMap<String, Double>();
		Map<String,Double> averageBudgetByStatus=new HashMap<String, Double>();
		Map<String,Double> deviationBudgetByStatus=new HashMap<String, Double>();
		Map<String,Double> minBudgetByStatus=new HashMap<String, Double>();
		Map<String,Double> maxBudgetByStatus=new HashMap<String, Double>();

		int i=0;
		
		while(i<this.repository.averageRetailPriceOfComponents().size()) {
			String linea= this.repository.averageRetailPriceOfComponents().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[2]);
			String divisa=sub[0];
			String tecnologia= sub[1];
			Pair<String, String> res=Pair.of(divisa, tecnologia);
			averageRetailPriceOfComponents.put(res, key);
			i++;
		}
		i=0;
		
		while(i<this.repository.deviationRetailPriceOfComponents().size()) {
			String linea= this.repository.deviationRetailPriceOfComponents().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[2]);
			String divisa=sub[0];
			String tecnologia= sub[1];
			Pair<String, String> res=Pair.of(divisa, tecnologia);
			deviationRetailPriceOfComponents.put(res, key);
			i++;
		}
	i=0;
		while(i<this.repository.minRetailPriceOfComponents().size()) {
			String linea= this.repository.minRetailPriceOfComponents().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[2]);
			String divisa=sub[0];
			String tecnologia= sub[1];
			Pair<String, String> res=Pair.of(divisa, tecnologia);
			minRetailPriceOfComponents.put(res, key);
			i++;
		}
	i=0;
		
		while(i<this.repository.maxRetailPriceOfComponents().size()) {
			String linea= this.repository.maxRetailPriceOfComponents().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[2]);
			String divisa=sub[0];
			String tecnologia= sub[1];
			Pair<String, String> res=Pair.of(divisa, tecnologia);
			maxRetailPriceOfComponents.put(res, key);
			i++;
		 }
	i=0;
	
		while(i<this.repository.averageRetailPriceOfTools().size()) {
			String linea= this.repository.averageRetailPriceOfTools().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			averageRetailPriceOfTools.put(divisa, key);
			i++;
		 }
	i=0;
		while(i<this.repository.deviationRetailPriceOfTools().size()) {
			String linea= this.repository.deviationRetailPriceOfTools().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			deviationRetailPriceOfTools.put(divisa, key);
			i++;
		 }
		i=0;
		
		while(i<this.repository.minRetailPriceOfTools().size()) {
			String linea= this.repository.minRetailPriceOfTools().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			minRetailPriceOfTools.put(divisa, key);
			i++;
		 }
		i=0;
		
		while(i<this.repository.maxRetailPriceOfTools().size()) {
			String linea= this.repository.maxRetailPriceOfTools().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String divisa=sub[0];
			maxRetailPriceOfTools.put(divisa, key);
			i++;
		 }
		i=0;
		while(i<this.repository.averageBudgetByStatus().size()) {
			String linea= this.repository.averageBudgetByStatus().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String status=sub[2];
			averageBudgetByStatus.put(status, key);
			i++;
		 }
		i=0;
		while(i<this.repository.deviationBudgetByStatus().size()) {
			String linea= this.repository.deviationBudgetByStatus().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String status=sub[2];
			deviationBudgetByStatus.put(status, key);
			i++;
		 }
		i=0;
		while(i<this.repository.minBudgetByStatus().size()) {
			String linea= this.repository.minBudgetByStatus().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String status=sub[2];
			minBudgetByStatus.put(status, key);
			i++;
		 }
		i=0;
		while(i<this.repository.maxBudgetByStatus().size()) {
			String linea= this.repository.maxBudgetByStatus().get(i);
			String[] sub=linea.split(",");
			Double key=Double.parseDouble(sub[1]);
			String status=sub[2];
			maxBudgetByStatus.put(status, key);
			i++;
		 }		
		result.setTotalNumberOfAcceptedPatronages(totalNumberOfAcceptedPatronages);
		result.setTotalNumberOfProposedPatronages(totalNumberOfProposedPatronages);
		result.setTotalNumberOfDeniedPatronages(totalNumberOfDeniedPatronages);
		
		result.setTotalNumberOfComponents(totalNumberOfComponents);
		result.setAverageRetailPriceOfComponents(averageRetailPriceOfComponents);
		result.setDeviationRetailPriceOfComponents(deviationRetailPriceOfComponents);
		result.setMaxRetailPriceOfComponents(maxRetailPriceOfComponents);
		result.setMinRetailPriceOfComponents(minRetailPriceOfComponents);
		
		result.setTotalNumberOfTools(totalNumberOfTools);
		result.setAverageRetailPriceOfTools(averageRetailPriceOfTools);
		result.setDeviationRetailPriceOfTools(deviationRetailPriceOfTools);
		result.setMinRetailPriceOfTools(minRetailPriceOfTools);
		result.setMaxRetailPriceOfTools(maxRetailPriceOfTools);
		
		result.setAverageBudgetByStatus(averageBudgetByStatus);
		result.setDeviationBudgetByStatus(deviationBudgetByStatus);
		result.setMaxBudgetByStatus(maxBudgetByStatus);
		result.setMinBudgetByStatus(minBudgetByStatus);
		
		
		
		
		return result;
	}

	@Override
	public void unbind(Request<AdministratorDashboard> request, AdministratorDashboard entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfProposedPatronages", "totalNumberOfAcceptedPatronages", "totalNumberOfDeniedPatronages", 
			"totalNumberOfComponents", "averageRetailPriceOfComponents", "deviationRetailPriceOfComponents", "minRetailPriceOfComponents","maxRetailPriceOfComponents",
			"totalNumberOfTools","averageRetailPriceOfTools","deviationRetailPriceOfTools","minRetailPriceOfTools","maxRetailPriceOfTools","averageBudgetByStatus","deviationBudgetByStatus","maxBudgetByStatus","minBudgetByStatus");
	}}


