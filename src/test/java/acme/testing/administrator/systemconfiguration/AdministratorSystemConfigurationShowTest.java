package acme.testing.administrator.systemconfiguration;

import org.junit.jupiter.api.Order;
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
			final String weakSpamWords, final String weakSpamThreshold) {
			
			super.signIn("administrator", "administrator");

			super.clickOnMenu("Administrator", "System configuration");

			super.checkFormExists();
			super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
			super.checkInputBoxHasValue("systemCurrency", systemCurrency);
			super.checkInputBoxHasValue("strongSpamWords", strongSpamWords);
			super.checkInputBoxHasValue("strongSpamThreshold", strongSpamThreshold);
			super.checkInputBoxHasValue("weakSpamWords", weakSpamWords);
			super.checkInputBoxHasValue("weakSpamThreshold", weakSpamThreshold);

			super.signOut();
		}

		// Ancillary methods ------------------------------------------------------


}
