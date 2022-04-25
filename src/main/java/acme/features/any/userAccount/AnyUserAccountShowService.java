package acme.features.any.userAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Administrator;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyUserAccountShowService implements AbstractShowService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountRepository repository;

	// AbstractShowService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		boolean result = true;
		final int id = request.getModel().getInteger("id");
		final UserAccount userAccount = this.repository.findOneUserAccountById(id);
		final boolean isAnonymous = userAccount.isAnonymous();
		final boolean isAdministrator = userAccount.hasRole(Administrator.class);
		
		if(!userAccount.isEnabled() || isAnonymous || isAdministrator) {
			result = false;
		}
		
		return result;
	}

	@Override
	public UserAccount findOne(final Request<UserAccount> request) {
		assert request != null;

		UserAccount result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneUserAccountById(id);
		result.getRoles().forEach(r -> {
		});

		return result;
	}
	
	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");
	}

}