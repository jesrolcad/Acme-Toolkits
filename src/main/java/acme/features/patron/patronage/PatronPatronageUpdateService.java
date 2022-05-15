package acme.features.patron.patronage;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;
@Service
public class PatronPatronageUpdateService implements AbstractUpdateService<Patron, Patronage>{
	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractUpdateService<Patron, Patronage> -------------------------------------


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
	//	entity.setInventor(this.repository.findInventorById(Integer.valueOf(request.getModel().getAttribute("inventorId").toString())));


		request.bind(entity, errors, "code", "legalStuff", "budget", "startDate", "endDate","link");
	}

	@Override
	public void validate(Request<Patronage> request, Patronage entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("code")) {
			Patronage existing;

			existing = this.repository.findPatronageByCode(entity.getCode());
			if(existing==null) {
				existing=entity;
			}
			errors.state(request, existing != null||entity.getCode()==existing.getCode(), "code", "patron.patronage.form.error.duplicated");
		}
		if(!errors.hasErrors("startDate")) {
			final Date minimumStartDate=DateUtils.addMonths(new Date(System.currentTimeMillis() - 1),1);

			
			errors.state(request,entity.getStartDate().after(minimumStartDate), "startDate", "patron.patronage.form.error.too-close-start-date");
			
		}
		if(!errors.hasErrors("endDate")) {
			final Date minimumFinishDate=DateUtils.addMonths(entity.getStartDate(), 1);

			errors.state(request,entity.getEndDate().after(minimumFinishDate), "endDate", "patron.patronage.form.error.one-month");
			
		}
		if (!errors.hasErrors("budget")) {
			final String[] currencies=this.repository.findSystemConfiguration().getAcceptedCurrencies().split(",");

            Boolean acceptedCurrency=false;
            for(int i=0;i<currencies.length;i++) {
	                if(entity.getBudget().getCurrency().equals(currencies[i].trim())) {
                    acceptedCurrency=true;
                }
            }
			
			errors.state(request, entity.getBudget().getAmount() > 0, "budget", "patron.patronage.form.error.negative-budget");
			errors.state(request, acceptedCurrency, "budget", "patron.patronage.form.error.non-accepted-currency");
		}
		

	}


	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "legalStuff", "budget", "startDate", "endDate","link","published");
		model.setAttribute("inventors", this.repository.allInventors());
		model.setAttribute("inventorId", entity.getInventor().getId());
		
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
	
		entity.setPublished(false);
		this.repository.save(entity);

	}
}