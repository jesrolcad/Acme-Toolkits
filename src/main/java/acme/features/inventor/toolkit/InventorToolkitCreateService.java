package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamFilter;
import acme.entities.Toolkit;
import acme.features.administrator.systemconfiguration.AdministratorSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit>{
	@Autowired 
	protected AdministratorSystemConfigurationRepository scRepository; 
	
	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request !=null;
		return true;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code","title", 
			"description","assemblyNotes", "optionalLink");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,"code","title", 
			"description","assemblyNotes","published", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;
		Toolkit result;
		Inventor inventor;
		
		inventor=this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		result= new Toolkit();
		result.setPublished(false);
		result.setInventor(inventor);
		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (!errors.hasErrors("title")) {
            errors.state(request, SpamFilter.spamValidator(entity.getTitle(), this.scRepository.findWeakSpamWords(), this.scRepository.findStrongSpamWords(),this.scRepository.findWeakSpamThreshold(),this.scRepository.findStrongSpamThreshold()), "title", "form.error.spam");
        }
		if (!errors.hasErrors("assemblyNotes")) {
            errors.state(request, SpamFilter.spamValidator(entity.getAssemblyNotes(), this.scRepository.findWeakSpamWords(), this.scRepository.findStrongSpamWords(),this.scRepository.findWeakSpamThreshold(),this.scRepository.findStrongSpamThreshold()), "assemblyNotes", "form.error.spam");
        }
		if (!errors.hasErrors("description")) {
            errors.state(request, SpamFilter.spamValidator(entity.getDescription(), this.scRepository.findWeakSpamWords(), this.scRepository.findStrongSpamWords(),this.scRepository.findWeakSpamThreshold(),this.scRepository.findStrongSpamThreshold()), "description", "form.error.spam");
        }
		if(!errors.hasErrors("code")) {
			Toolkit existing;
			
			existing = this.repository.findOneToolkitByCode(entity.getCode());
			errors.state(request, existing == null, "code", "inventor.toolkit.form.error.duplicated");
		}
		
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		
		entity.setInventor(this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId()));
		entity.setPublished(false);
		this.repository.save(entity);
		
	}

}
