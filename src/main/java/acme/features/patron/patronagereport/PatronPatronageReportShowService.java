package acme.features.patron.patronagereport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron; 
 
@Service 
public class PatronPatronageReportShowService implements AbstractShowService<Patron, PatronageReport>{ 
	 
	 
	@Autowired 
	protected PatronPatronageReportRepository repository; 
	
	@Override 
	public boolean authorise(final Request<PatronageReport> request) { 
		assert request != null;
		boolean result;
		int patronageID;
		Patron patron;
		PatronageReport pat;
		
		patronageID = request.getModel().getInteger("id");
		pat = this.repository.findPatronageReportById(patronageID);
		patron =this.repository.findPatronByUserAccountId(request.getPrincipal().getAccountId());
		result = pat.getPatronage().getPatron().equals(patron);
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
