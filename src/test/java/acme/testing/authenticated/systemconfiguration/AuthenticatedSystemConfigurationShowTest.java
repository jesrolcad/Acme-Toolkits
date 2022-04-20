package acme.testing.authenticated.systemconfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedSystemConfigurationShowTest extends TestHarness{
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/system-configuration/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String acceptedCurrencies, final String systemCurrency) {
		
		
	super.signIn("inventor1", "inventor1");	
	
	super.clickOnMenu("Authenticated", "System configuration");
	//Show
	super.checkFormExists();
	super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
	super.checkInputBoxHasValue("systemCurrency", systemCurrency);
	
	super.signOut();
	}
}
