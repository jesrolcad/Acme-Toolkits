package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemListShowMineTest extends TestHarness{
	
	//COMPONENT
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/component/items.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponentMine(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String published, final String optionalLink, final String inventor) {
		
		
		super.signIn("inventor1", "inventor1");

		//list
		super.clickOnMenu("Inventor", "My own published Components");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, technology);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);
		super.checkColumnHasValue(recordIndex, 4, inventor);
		//show
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("published", published);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		super.checkInputBoxHasValue("inventor", inventor);

		super.signOut();
	}
	//TOOL
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/tool/items.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveToolMine(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String published, final String optionalLink, final String inventor) {
		
		
		super.signIn("inventor1", "inventor1");
		//list
		super.clickOnMenu("Inventor", "My own published Tools");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, technology);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);
		super.checkColumnHasValue(recordIndex, 4, inventor);
		//show
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("published", published);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		//super.checkInputBoxHasValue("inventor", inventor);

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
