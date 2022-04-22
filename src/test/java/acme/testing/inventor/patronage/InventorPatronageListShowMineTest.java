package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageListShowMineTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link, final String patron_company, final String patron_link, final String patron_statement) {
		
		
		super.signIn("inventor1", "inventor1");
		//list
		super.clickOnMenu("Inventor", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, budget);
		super.checkColumnHasValue(recordIndex, 2, start_date);
		super.checkColumnHasValue(recordIndex, 3, end_date);
		super.checkColumnHasValue(recordIndex, 4, status);
		
		//show
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("startDate", start_date);
		super.checkInputBoxHasValue("endDate", end_date);
		super.checkInputBoxHasValue("legalStuff", legal_stuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("patron.company", patron_company);
		super.checkInputBoxHasValue("patron.link", patron_link);
		super.checkInputBoxHasValue("patron.statement", patron_statement);

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
