package acme.testing.any.item.component;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyComponentListPublishedTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/component/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousPositive(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink, final String inventor, final String published) {
		

		super.clickOnMenu("Anonymous", "List published components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, technology);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		super.checkInputBoxHasValue("inventor", inventor);
		super.checkInputBoxHasValue("published", published);

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/component/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void authenticatedPositive(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink, final String inventor, final String published) {
		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Authenticated", "List published components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, technology);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipo", tipo);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		super.checkInputBoxHasValue("inventor", inventor);
		super.checkInputBoxHasValue("published", published);
		
		super.signOut();

	}

	// Ancillary methods ------------------------------------------------------

}
