
package acme.features.any.userAccount;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyUserAccountRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("select ua from UserAccount ua where ua.enabled = 1")
	Collection<UserAccount> findAllUserAccounts();
	
	@Query("select p.userAccount from Patron p where p.userAccount.enabled = 1")
	Collection<UserAccount> findPatronUserAccounts();
	
	@Query("select i.userAccount from Inventor i where i.userAccount.enabled = 1")
	Collection<UserAccount> findInventorUserAccounts();
	

}
