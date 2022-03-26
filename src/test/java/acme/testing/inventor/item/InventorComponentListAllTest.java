package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorComponentListAllTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/component/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink, final String inventor) {
		
		
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List published components");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 0, tipo);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, technology);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		super.checkInputBoxHasValue("item.inventor", inventor);

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
