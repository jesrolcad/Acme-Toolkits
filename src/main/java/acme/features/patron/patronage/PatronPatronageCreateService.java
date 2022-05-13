package acme.features.patron.patronage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Patron;
@Service
public class PatronPatronageCreateService  implements AbstractCreateService<Patron, Patronage>{
	@Autowired
	protected PatronPatronageRepository repository;

	@Override
	public boolean authorise(Request<Patronage> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(Request<Patronage> request, Patronage entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "startDate","endDate","legalStuff","link","budget","inventor","status");
		
	}	

	@Override
	public void unbind(Request<Patronage> request, Patronage entity, Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		 
		request.unbind(entity, model, "code", "startDate","endDate","legalStuff","link","budget","inventor","status");
	}


	@Override
	public Patronage instantiate(Request<Patronage> request) {
		assert request != null;
		Patronage result = new Patronage();
		String code = "";
		String auxLetras = "";
		String auxNum = "";
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVXTZ";
		int i = 0;
		while (i < 3) {
			Random rnd = new Random();
			char c = chars.charAt(rnd.nextInt(chars.length()));
			auxLetras = auxLetras + c;
			int randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
			auxNum = auxNum + randomNum;
			i++;
		}
		code = code + auxLetras + "-" + auxNum;
		result.setCode(code);
		
		return result;
	}

	@Override
	public void validate(Request<Patronage> request, Patronage entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (!errors.hasErrors("budget")) {
			errors.state(request, entity.getBudget().getAmount()<=0.0, "startDate", "patron.patronage.form.error.incorrect.budget");
			
		}

	
	}

	@Override
	public void create(Request<Patronage> request, Patronage entity) {
		assert request != null;
		assert entity != null;		
		this.repository.save(entity);

	}

}
