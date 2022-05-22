package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Patron;
@Service
public class PatronPatronageDeleteService  implements AbstractDeleteService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractDeleteService<Patron, Patronage> -------------------------------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		boolean result;
		int patronageId;
		Patronage patronage;

		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(patronageId);
		result = (patronage != null && !patronage.isPublished() && request.isPrincipal(patronage.getPatron()));

		return result;
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findPatronageById(id);

		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code", "legalStuff", "budget", "startDate", "endDate","link");
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "legalStuff", "budget", "startDate", "endDate","link","published");
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		for (PatronageReport p : this.repository.findPatronagesReportByPatronageId(entity.getId())) {
			this.repository.delete(p);
		}

		this.repository.delete(entity);
	}
	

}
