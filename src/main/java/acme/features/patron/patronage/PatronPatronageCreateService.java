package acme.features.patron.patronage;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.Status;
import acme.features.administrator.systemconfiguration.AdministratorSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Patron;
@Service
public class PatronPatronageCreateService  implements AbstractCreateService<Patron, Patronage>{	
	@Autowired
	protected PatronPatronageRepository repository;
	@Autowired
	protected AdministratorSystemConfigurationRepository scRepository;
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;

		entity.setStatus(Status.PROPOSED);
		entity.setPublished(false);
		if(this.repository.allInventors().isEmpty()) {			
			request.bind(entity, errors, "code", "startDate","endDate","legalStuff","link","budget");

			
		}else {
		entity.setInventor(this.repository.findInventorById(Integer.valueOf(request.getModel().getAttribute("inventorId").toString())));
		request.bind(entity, errors, "code", "startDate","endDate","legalStuff","link","budget","inventorId");
		}
	}	

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {

		assert request != null; 
		assert entity != null; 
		assert model != null; 

		request.unbind(entity, model, "code", "startDate","endDate","legalStuff","link","budget","published");
		model.setAttribute("inventors", this.repository.allInventors());

	}


	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;
		final Patronage result = new Patronage();

		result.setLegalStuff("");
//		result.setStartDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),6));
//		result.setEndDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),8));
		result.setPatron(this.repository.findPatronByUserAccountId(request.getPrincipal().getAccountId()));

		
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		 if(entity.getInventor()==null) {
	            errors.state(request, entity.getInventor() != null, "inventorId", "patron.patronage.form.error.noInventor");
	        }
    
		if (!errors.hasErrors("code")) {
			Patronage existing;
			
			existing = this.repository.findPatronageByCode(entity.getCode());
			
			errors.state(request, existing == null, "code", "patron.patronage.form.error.duplicated");
		}
		if(!errors.hasErrors("startDate")) {
			final Date minimumStartDate=DateUtils.addMonths(new Date(System.currentTimeMillis() - 1),1);

			
			errors.state(request,entity.getStartDate().after(minimumStartDate), "startDate", "patron.patronage.form.error.too-close-start-date");
			
		}
		if(!errors.hasErrors("endDate") && !errors.hasErrors("startDate")) {
			final Date minimumFinishDate=(DateUtils.addDays(entity.getStartDate(), 28));
			

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
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;		
		this.repository.save(entity);
	}

}
