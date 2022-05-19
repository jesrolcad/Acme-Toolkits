package acme.features.administrator.systemconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.HttpMethod;
import acme.framework.controllers.Request;
import acme.framework.controllers.Response;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorSystemConfigurationUpdateService implements AbstractUpdateService<Administrator, SystemConfiguration>{
	
	@Autowired
	protected AdministratorSystemConfigurationRepository repository;
	
	@Override
	public boolean authorise(final Request<SystemConfiguration> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "acceptedCurrencies", "systemCurrency", "strongSpamWords", 
			"strongSpamThreshold", "weakSpamWords", "weakSpamThreshold","moneyExchangeServiceName","moneyExchangeServiceDescription",
			"moneyExchangeServiceLink");

	}

	@Override
	public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "acceptedCurrencies", "systemCurrency", "strongSpamWords", 
			"strongSpamThreshold", "weakSpamWords", "weakSpamThreshold","moneyExchangeServiceName","moneyExchangeServiceDescription",
			"moneyExchangeServiceLink");
//		model.setAttribute("confirmation", false);
		
	}

	@Override
	public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
		assert request != null;

		SystemConfiguration result;
		result = this.repository.findSystemConfiguration();
		return result;
	}

	@Override
	public void validate(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(final Request<SystemConfiguration> request, final SystemConfiguration entity) {
		assert request!=null;
		assert entity!=null;
		
		this.repository.save(entity);
		
	}
	
	@Override
	public void onSuccess(final Request<SystemConfiguration> request, final Response<SystemConfiguration> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}


}
