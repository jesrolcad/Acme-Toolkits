package acme.testing.any.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyToolkitListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String code, final String description,
		final String assemblynotes) {
		
		super.clickOnMenu("Any", "List published toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, assemblynotes);
		
		//show
		/*super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblynotes);
		super.checkInputBoxHasValue("optionalLink", link);
		super.checkInputBoxHasValue("retailPrice", retailprice);;
		super.checkInputBoxHasValue("inventor.userAccount.username", inventor);
		super.clickOnButton("Items");
		super.checkListingExists();*/

	
	}

	// Ancillary methods ------------------------------------------------------

}
