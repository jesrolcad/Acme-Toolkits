package acme.features.inventor.patronagereport;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport>{
	@Autowired
	protected InventorPatronageReportRepository repository;
	

	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "creationMoment", "sequenceNumber","memorandum", "link");
		
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		 
		request.unbind(entity, model, "creationMoment","sequenceNumber", "memorandum", "link");	 
		model.setAttribute("confirmation", false); 
		model.setAttribute("readonly", false); 
		model.setAttribute("status", entity.getPatronage().getStatus());
		model.setAttribute("patronageId", entity.getPatronage().getId());
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;
		int patronageId;
		final PatronageReport result = new PatronageReport();
		Patronage patronage;
		Date creationMoment;
		String sequenceNumber = "";
		String salida;
		patronageId= request.getModel().getInteger("patronageId");
		patronage = this.repository.findPatronageById(patronageId);
		
		final int aux= this.repository.totalNumberPatronagesWithSameCode(patronage.getCode())+1;
		if(aux<10) {
			 salida= "000"+aux; 
		}else if(aux<100){
			 salida = "00" + aux;
			
		}else if(aux<1000){
			 salida ="0"+ aux;
		}else {
			 salida = ""+aux;
		}
		

		sequenceNumber = sequenceNumber+patronage.getCode()+":"+salida;

		creationMoment = new Date(System.currentTimeMillis() - 1);
		result.setPatronage(patronage);
		result.setCreationMoment(creationMoment);
		result.setSequenceNumber(sequenceNumber);
		return result;
	
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (!errors.hasErrors("memorandum")) {
			errors.state(request, entity.getMemorandum().length()<256, "memorandum", "inventor.patronageReport.form.error.incorrect.memorandum");
			
		}

		boolean confirmation;
		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "patron.patronageReport.confirmation.error");
		
	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;
		Date creationMoment;
		creationMoment = new Date(System.currentTimeMillis()-1);
		entity.setCreationMoment(creationMoment);
		this.repository.save(entity);
		

	}

}
