

package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Administrator;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListService implements AbstractListService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountRepository repository;

	// AbstractListService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder buffer;
		Collection<UserRole> roles;

		request.unbind(entity, model);

		roles = entity.getRoles();
		buffer = new StringBuilder();
		for (final UserRole rol : roles) {
			final boolean rolAnonimo = rol.getUserAccount().isAnonymous();
			final boolean rolAdministrator = rol.getUserAccount().hasRoleClass(Administrator.class);
			
			if(!rolAnonimo && !rolAdministrator) {
				buffer.append(rol.getAuthorityName());
				buffer.append(" ");
			}
			
		}
		
		model.setAttribute("roles", buffer.toString());
		System.out.println(buffer.toString().length());
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;

		result = this.repository.findPatronUserAccounts();
		result.addAll(this.repository.findInventorUserAccounts());
		for (final UserAccount userAccount : result) {
			userAccount.getRoles().forEach(r -> {
			});
		}

		return result;
	}

}