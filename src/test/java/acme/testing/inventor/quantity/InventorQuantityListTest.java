package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex, final String toolkitCode, final int quantityRecordIndex, final String type, final String name, final String retailPrice, final String quantity) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(toolkitRecordIndex, 0, toolkitCode);
		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkInputBoxHasValue("code", toolkitCode);
		super.clickOnButton("Items");

		super.checkListingExists();
		super.sortListing(3, "asc");
		super.checkColumnHasValue(quantityRecordIndex, 0, type);
		super.checkColumnHasValue(quantityRecordIndex, 1, name);
		super.checkColumnHasValue(quantityRecordIndex, 2, retailPrice);
		super.checkColumnHasValue(quantityRecordIndex, 3, quantity);
		super.clickOnListingRecord(quantityRecordIndex);
	
		super.signOut();
	}

}
