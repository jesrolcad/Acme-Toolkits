package acme.testing.any.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyToolkitShowTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String code, final String title, final String description,
		final String assemblynotes, final String link) {

		super.clickOnMenu("Any", "List published toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblynotes);
		super.checkInputBoxHasValue("optionalLink", link);
		super.clickOnButton("Items");
		super.checkListingExists();
	}

	// Ancillary methods ------------------------------------------------------

}