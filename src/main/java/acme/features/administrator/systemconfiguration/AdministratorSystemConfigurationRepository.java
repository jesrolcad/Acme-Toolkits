package acme.features.administrator.systemconfiguration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSystemConfigurationRepository extends AbstractRepository{
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();

}
