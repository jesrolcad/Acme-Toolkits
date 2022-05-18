package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String code, final String description,
		final String assemblynotes, final String link,final String published, final String inventor) {
		
		
		super.signIn("inventor1", "inventor1");
		//list
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, assemblynotes);
		

		super.signOut();
	}
	@Test
	@Order(20)
	public void negativeTest() {
		// Es una lista, asi que no hay datos para un caso negativo
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
