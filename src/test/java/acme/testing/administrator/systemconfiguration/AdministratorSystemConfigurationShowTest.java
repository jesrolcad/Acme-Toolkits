package acme.testing.administrator.systemconfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorSystemConfigurationShowTest extends TestHarness{
	
	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------

		@ParameterizedTest
		@CsvFileSource(resources = "/administrator/system-configuration/show.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positive(final int recordIndex, final String acceptedCurrencies, final String systemCurrency, 
			final String strongSpamWords, final String strongSpamThreshold, 
			final String weakSpamWords, final String weakSpamThreshold,
			final String money_exchange_service_name, final String money_exchange_service_description,
			final String money_exchange_service_link) {
			
			super.signIn("administrator", "administrator");

			super.clickOnMenu("Administrator", "System configuration");

			super.checkFormExists();
			super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
			super.checkInputBoxHasValue("systemCurrency", systemCurrency);
			super.checkInputBoxHasValue("strongSpamWords", strongSpamWords);
			super.checkInputBoxHasValue("strongSpamThreshold", strongSpamThreshold);
			super.checkInputBoxHasValue("weakSpamWords", weakSpamWords);
			super.checkInputBoxHasValue("weakSpamThreshold", weakSpamThreshold);
			
			super.checkInputBoxHasValue("moneyExchangeServiceName", money_exchange_service_name);
			super.checkInputBoxHasValue("moneyExchangeServiceDescription", money_exchange_service_description);
			super.checkInputBoxHasValue("moneyExchangeServiceLink", money_exchange_service_link);
			
			super.signOut();
		}
		
		@Test
		@Order(30)
		public void hackingTest() {
			super.navigate("/administrator/system-configuration/show");
			super.checkPanicExists();

			super.signIn("inventor1", "inventor1");
			super.navigate("/administrator/system-configuration/show");
			super.checkPanicExists();
			super.signOut();
			
			super.signIn("patron1", "patron1");
			super.navigate("/administrator/system-configuration/show");
			super.checkPanicExists();
			super.signOut();
		}

		// Ancillary methods ------------------------------------------------------


}
