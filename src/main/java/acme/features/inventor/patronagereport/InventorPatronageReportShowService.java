package acme.features.inventor.patronagereport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor; 
 
@Service 
public class InventorPatronageReportShowService implements AbstractShowService<Inventor, PatronageReport>{ 
	 
	 
	@Autowired 
	protected InventorPatronageReportRepository repository; 
	
	@Override 
	public boolean authorise(final Request<PatronageReport> request) { 
		assert request != null;
		boolean result;
		int patronageReportID;
		Inventor inv;
		PatronageReport pat;
		
		patronageReportID = request.getModel().getInteger("id");
		pat = this.repository.findPatronageReportById(patronageReportID);
		inv =this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		result = pat.getPatronage().getInventor().equals(inv);
		return result; 
	} 
 
	@Override 
	public PatronageReport findOne(final Request<PatronageReport> request) { 
		assert request != null; 
		 
		PatronageReport result; 
		int id; 
		 
		id=request.getModel().getInteger("id"); 
		result=this.repository.findPatronageReportById(id);
		return result; 
	} 
 
	@Override 
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		 
		request.unbind(entity, model, "creationMoment","sequenceNumber", "memorandum", "link");	 
		model.setAttribute("confirmation", false); 
		model.setAttribute("readonly", true); 
	} 
 
} 
