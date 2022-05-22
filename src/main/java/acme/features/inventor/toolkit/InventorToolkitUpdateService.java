package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamFilter;
import acme.entities.Toolkit;
import acme.features.administrator.systemconfiguration.AdministratorSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitUpdateService implements AbstractUpdateService<Inventor, Toolkit>{
	@Autowired 
	protected AdministratorSystemConfigurationRepository scRepository; 
	@Autowired
	protected InventorToolkitRepository repository;
	 
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		final boolean result;
		int toolkitId;
		final Toolkit toolkit;
		final Inventor inventor;
		
		toolkitId=request.getModel().getInteger("id");
		toolkit=this.repository.findOneToolkitById(toolkitId);
		inventor=toolkit.getInventor();
		
		result= !toolkit.isPublished() && request.isPrincipal(inventor);
		
		
		return result;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code","title", 
			"description","assemblyNotes", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("masterId", request.getModel().getInteger("masterId"));

		request.unbind(entity, model,"code","title", 
			"description","assemblyNotes","published", "optionalLink", 
			"inventor.userAccount.username","retailPrice");
		
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		int id;
		
		id=request.getModel().getInteger("id");
		result=this.repository.findOneToolkitById(id);
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
			errors.state(request, existing == null || existing.getId() == entity.getId(), "code", "inventor.toolkit.form.error.duplicated");
		}
		
		
	}

	@Override
	public void update(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
		
	}

}
