package acme.testing.authenticated.systemconfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedSystemConfigurationShowTest extends TestHarness{
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/system-configuration/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String acceptedCurrencies, final String systemCurrency,
		final String moneyExchangeServiceName,final String moneyExchangeServiceDescription, final String moneyExchangeServiceLink) {
		
		
	super.signIn("inventor1", "inventor1");	
	
	super.clickOnMenu("Authenticated", "System configuration");
	//Show
	super.checkFormExists();
	super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
	super.checkInputBoxHasValue("systemCurrency", systemCurrency);
	super.checkInputBoxHasValue("moneyExchangeServiceName", moneyExchangeServiceName);
	super.checkInputBoxHasValue("moneyExchangeServiceDescription", moneyExchangeServiceDescription);
	super.checkInputBoxHasValue("moneyExchangeServiceLink", moneyExchangeServiceLink);
	
	super.signOut();
	}
	
	@Test
	@Order(20)
	public void negativeTest() {
		//Esto es un show, asi que no deberia de tener tests con casos negativos
	}
	
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/authenticated/system-configuration/show");
		super.checkPanicExists();
		
	}
}
