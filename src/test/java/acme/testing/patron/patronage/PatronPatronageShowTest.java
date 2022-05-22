package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageShowTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("startDate", start_date);
		super.checkInputBoxHasValue("endDate", end_date);
		super.checkInputBoxHasValue("legalStuff", legal_stuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("link", link);
	

		super.signOut();
	}
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage/list");
		super.checkPanicExists();
	}
	// Ancillary methods ------------------------------------------------------

}
