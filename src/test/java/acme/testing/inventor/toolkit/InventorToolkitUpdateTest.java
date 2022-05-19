package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitUpdateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String code,final String title, final String description,
		final String assemblynotes, final String link) {
		
		
		super.signIn("inventor2", "inventor2");
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("assemblyNotes", assemblynotes);
		super.fillInputBoxIn("optionalLink", link);
		
		super.clickOnSubmit("Update");
		super.clickOnMenu("Inventor", "List my toolkits");
		
		super.sortListing(2, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblynotes);
		super.checkInputBoxHasValue("optionalLink", link);
		super.clickOnButton("Items");
		super.checkListingExists();

		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String code,final String title, final String description,
		final String assemblynotes, final String link) {
		super.signIn("inventor2", "inventor2");
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("assemblyNotes", assemblynotes);
		super.fillInputBoxIn("optionalLink", link);
		
		super.clickOnSubmit("Update");
		super.checkErrorsExist();
		super.signOut();
	}
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/toolkit/list");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/toolkit/list");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/toolkit/list");
		super.checkPanicExists();
		super.signOut();
		
		
	}

	// Ancillary methods ------------------------------------------------------

}
