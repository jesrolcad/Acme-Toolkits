package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, budget);
		super.checkColumnHasValue(recordIndex, 2, start_date);
		super.checkColumnHasValue(recordIndex, 3, end_date);
		super.checkColumnHasValue(recordIndex, 4, status);

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
