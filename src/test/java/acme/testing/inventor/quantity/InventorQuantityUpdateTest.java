package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityUpdateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex, final int quantityRecordIndex, final String number) {
		super.signIn("inventor2", "inventor2");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkFormExists();

		super.clickOnButton("Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(quantityRecordIndex);
		
		super.fillInputBoxIn("number", number);
		super.clickOnSubmit("Update");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(quantityRecordIndex, 3, number);

		super.clickOnListingRecord(quantityRecordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("number", number);

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int toolkitRecordIndex, final int quantityRecordIndex, final String number) {
		super.signIn("inventor2", "inventor2");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkFormExists();

		super.clickOnButton("Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(quantityRecordIndex);
		
		super.fillInputBoxIn("number", number);
		super.clickOnSubmit("Update");
		super.checkErrorsExist();

		super.signOut();
	}
	
	//Este test prueba que no se pueden actualizar las cantidades de items de una toolkit ya publicada
		@ParameterizedTest
		@CsvFileSource(resources = "/inventor/quantity/update-negative-button.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(20)
		public void negativeButtonTest(final int toolkitRecordIndex, final String published, final int quantityRecordIndex) {
			super.signIn("inventor1", "inventor1");

			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			super.sortListing(0, "asc");

			super.clickOnListingRecord(toolkitRecordIndex);
			super.checkFormExists();
			super.checkInputBoxHasValue("published", published);
			super.clickOnButton("Items");
			
			super.clickOnListingRecord(quantityRecordIndex);

			super.checkNotButtonExists("Update");
			super.signOut();
			
		}
		
		@Test
		@Order(30)
		public void hackingTest() {
			super.navigate("/inventor/quantity/update");
			super.checkPanicExists();

			super.signIn("patron1", "patron1");
			super.navigate("/inventor/quantity/update");
			super.checkPanicExists();
			super.signOut();

			super.signIn("administrator", "administrator");
			super.navigate("/inventor/quantity/update");
			super.checkPanicExists();
			super.signOut();
		}

	

}
