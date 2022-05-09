package acme.features.any.chirp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractCreateService;

@Service
public class AnyChirpCreateService implements AbstractCreateService<Any, Chirp> {
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AnyChirpRepository repository;

	// AbstractCreateService<Administrator, Chirp> interface --------------


	@Override
	public boolean authorise(final Request<Chirp> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Chirp> request, final Chirp entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "body", "author", "email");
		
	}

	@Override
	public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "author", "email");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", false);
		
	}

	@Override
	public Chirp instantiate(final Request<Chirp> request) {
		assert request != null;

		final Chirp result;
		Date moment;

		result = new Chirp();
		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<Chirp> request, final Chirp entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean confirmation;

		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "any.Chirp.confirmation.error");
		
	}

	@Override
	public void create(final Request<Chirp> request, final Chirp entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
		
	}

}