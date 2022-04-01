package acme.testing.authenticated.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedItemListAllTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/item/component/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponent(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink, final String inventor) {
		
		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Authenticated", "List all components");
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
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/item/tool/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTool(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink, final String inventor) {
		
		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Authenticated", "List all tools");
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
