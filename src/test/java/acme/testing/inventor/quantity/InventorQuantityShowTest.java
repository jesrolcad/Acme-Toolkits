package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityShowTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex, final int quantityRecordIndex,
		final String quantity,final String type, final String name, final String itemCode,  final String retailPrice,
		final String toolkitCode) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.clickOnButton("Items");

		super.checkListingExists();
		super.sortListing(3, "asc");
		super.clickOnListingRecord(quantityRecordIndex);
		super.checkFormExists();
		
		
		super.checkInputBoxHasValue("number",quantity);
		super.checkInputBoxHasValue("item.tipo",type);
		super.checkInputBoxHasValue("item.name", name);
		super.checkInputBoxHasValue("item.code",itemCode);
		super.checkInputBoxHasValue("item.retailPrice",retailPrice);
		super.checkInputBoxHasValue("toolkit.code",toolkitCode);
	
		super.signOut();
	}

}
