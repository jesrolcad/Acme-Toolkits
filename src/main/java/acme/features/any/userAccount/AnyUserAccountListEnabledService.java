

package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListEnabledService implements AbstractListService<Any, UserAccount> {

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

		roles = entity.getRoles();
		buffer = new StringBuilder();
		
		int i = roles.size();
		
		for (final UserRole rol : roles) {
				buffer.append(rol.getAuthorityName());
				
				if(i > 1) {
					buffer.append(", ");
					i--;
				}
			
		}
		
		model.setAttribute("roles", buffer.toString());
		
		request.unbind(entity, model, "username", "identity.email");
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;
		
		result = this.repository.findEnabledUserAccounts();
		
		for (final UserAccount userAccount : result) {
			userAccount.getRoles().forEach(r -> { ; });
		}

		return result;
	}

}