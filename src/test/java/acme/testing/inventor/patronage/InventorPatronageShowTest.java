package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageShowTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/list-accepted-and-denied-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String username, final String patron_company, final String patron_link, final String patron_statement) {
		
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List accepted and denied patronages");
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
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("patron.userAccount.username", username);
		super.checkInputBoxHasValue("patron.company", patron_company);
		super.checkInputBoxHasValue("patron.link", patron_link);
		super.checkInputBoxHasValue("patron.statement", patron_statement);

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Inventor");
		super.navigate("/inventor/patronage/show");
		super.checkPanicExists();
	}

	// Ancillary methods ------------------------------------------------------

}
