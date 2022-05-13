package acme.features.inventor.patronagereport;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
	public boolean authorise(Request<PatronageReport> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(Request<PatronageReport> request, PatronageReport entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "creationMoment", "sequenceNumber","memorandum", "link");
		
	}

	@Override
	public void unbind(Request<PatronageReport> request, PatronageReport entity, Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		 
		request.unbind(entity, model, "creationMoment","sequenceNumber", "memorandum", "link");	 
		model.setAttribute("confirmation", false); 
		model.setAttribute("readonly", false); 
		model.setAttribute("patronageId", entity.getPatronage().getId());
	}

	@Override
	public PatronageReport instantiate(Request<PatronageReport> request) {
		assert request != null;
		int patronageId;
		PatronageReport result = new PatronageReport();
		Patronage patronage;
		Date creationMoment;
		String sequenceNumber = "";
		
		patronageId= request.getModel().getInteger("patronageId");
		patronage = this.repository.findPatronageById(patronageId);
		
		
		String auxLetras = "";
		String auxNum = "";
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i = 0;
		while (i < 3) {
			Random rnd = new Random();
			char c = chars.charAt(rnd.nextInt(chars.length()));
			auxLetras = auxLetras + c;
			int randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
			auxNum = auxNum + randomNum;
			i++;
		}
		Random rnd = new Random();
		sequenceNumber = sequenceNumber + auxLetras + "-" + auxNum + "-" + chars.charAt(rnd.nextInt(chars.length())) + ":" + auxNum  + ThreadLocalRandom.current().nextInt(0, 8 + 1);

		creationMoment = new Date(System.currentTimeMillis() - 1);
		result.setPatronage(patronage);
		result.setCreationMoment(creationMoment);
		result.setSequenceNumber(sequenceNumber);
		return result;
	
	}

	@Override
	public void validate(Request<PatronageReport> request, PatronageReport entity, Errors errors) {
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
	public void create(Request<PatronageReport> request, PatronageReport entity) {
		assert request != null;
		assert entity != null;
		Date creationMoment;
		creationMoment = new Date(System.currentTimeMillis()-1);
		entity.setCreationMoment(creationMoment);
		this.repository.save(entity);
		

	}

}
