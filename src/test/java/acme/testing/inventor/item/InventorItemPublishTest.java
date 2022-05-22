package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemPublishTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String tipo, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink) {
		
		
		super.signIn("inventor3", "inventor3");
		super.clickOnMenu("Inventor", "List my items");
		super.checkListingExists();
		super.sortListing(0, "desc");
		super.checkColumnHasValue(recordIndex, 2, code);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String code) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.checkNotButtonExists("Publish");
		
		
		super.signOut();
	}
	

	// Ancillary methods ------------------------------------------------------

}
