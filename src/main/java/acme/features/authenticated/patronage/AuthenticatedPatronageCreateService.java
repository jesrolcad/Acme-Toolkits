package acme.features.authenticated.patronage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.HttpMethod;
import acme.framework.controllers.Request;
import acme.framework.controllers.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class AuthenticatedPatronageCreateService implements AbstractCreateService<Authenticated, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedPatronageRepository repository;

	// AbstractCreateService<Authenticated, Patronage> interface ---------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		boolean result;
		
		result = request.getPrincipal().hasRole(Patron.class)||request.getPrincipal().hasRole(Inventor.class); 

		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "status", "code", "legalStuff", "budget", "startDate", "endDate", "link", "patron", "inventor");
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "startDate", "endDate", "link", "patron", "inventor");
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		Principal principal;
		int patronId;

		principal = request.getPrincipal();
		patronId = principal.getAccountId();
		

		result = new Patronage();
		result.setPatron(this.repository.findOnePatronById(patronId));

		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Patronage> request, final Response<Patronage> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
