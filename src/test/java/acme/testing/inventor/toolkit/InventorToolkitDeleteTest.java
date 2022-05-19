package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitDeleteTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String code,final String title, final String description,
		final String assemblynotes) {
		
		
		super.signIn("inventor2", "inventor2");
		//list
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, assemblynotes);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblynotes);
		super.clickOnSubmit("Delete");
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkNotErrorsExist();

		super.signOut();
	}
	@Test
	@Order(20)
	public void negativeTest() {
		// Es delete, asi que no hay datos para un caso negativo
	}
	
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/toolkit/create");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/toolkit/create");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/toolkit/create");
		super.checkPanicExists();
		super.signOut();
		
		
	}


	// Ancillary methods ------------------------------------------------------

}
