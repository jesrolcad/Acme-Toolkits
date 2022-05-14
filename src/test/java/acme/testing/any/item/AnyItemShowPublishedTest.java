package acme.testing.any.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyItemShowPublishedTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String tipo, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String optionalLink, final String inventor, final String published) {
		
		super.clickOnMenu("Any", "List published items");
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
		super.checkInputBoxHasValue("inventor.userAccount.username", inventor);
		super.checkInputBoxHasValue("published", published);
		
		
	}
}

