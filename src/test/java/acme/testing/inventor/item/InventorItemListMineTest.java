package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemListMineTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String tipo, final String name, final String code, final String technology, final String retailPrice) {
		
		
		super.signIn("inventor1", "inventor1");
		//list
		super.clickOnMenu("Inventor", "List my items");
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.checkColumnHasValue(recordIndex, 0, tipo);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, technology);
		super.checkColumnHasValue(recordIndex, 4, retailPrice);
		

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
		super.navigate("/inventor/item/list");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/item/list");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/item/list");
		super.checkPanicExists();
		super.signOut();
		
		
	}


	// Ancillary methods ------------------------------------------------------

}