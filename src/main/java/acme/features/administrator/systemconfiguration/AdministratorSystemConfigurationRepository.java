package acme.features.administrator.systemconfiguration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSystemConfigurationRepository extends AbstractRepository{
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration findSystemConfiguration();
	@Query("select sc.weakSpamWords from SystemConfiguration sc")
	String findWeakSpamWords();
	@Query("select sc.strongSpamWords from SystemConfiguration sc")
	String findStrongSpamWords();
	@Query("select sc.weakSpamThreshold from SystemConfiguration sc")
	double findWeakSpamThreshold();
	@Query("select sc.strongSpamThreshold from SystemConfiguration sc")
	double findStrongSpamThreshold();
	

}
