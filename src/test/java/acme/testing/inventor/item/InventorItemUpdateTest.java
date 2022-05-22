package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemUpdateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final int updatedRecordIndex, final String tipo, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink) {
		
		
		super.signIn("inventor3", "inventor3");
		super.clickOnMenu("Inventor", "List my items");
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("tipo", tipo);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("optionalLink", optionalLink);
		
		super.clickOnSubmit("Update");
		
		super.clickOnListingRecord(updatedRecordIndex);
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);

		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest1(final int recordIndex, final String tipo, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink) {
		super.signIn("inventor3", "inventor3");
		super.clickOnMenu("Inventor", "List my items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("tipo", tipo);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("optionalLink", optionalLink);
		
		super.clickOnSubmit("Update");
		super.checkErrorsExist();
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/update-negative2.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest2(final int recordIndex, final String tipo, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		super.checkNotSubmitExists("Update");
		
		super.signOut();
	}
	
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/item/update");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/item/update");
		super.checkPanicExists();
		super.signOut();

		super.signIn("patron1", "patron1");
		super.navigate("/inventor/item/update");
		super.checkPanicExists();
		super.signOut();

	}

	// Ancillary methods ------------------------------------------------------

}
