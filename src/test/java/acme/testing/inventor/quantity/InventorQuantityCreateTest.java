package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/employer/duty/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex, final int quantityRecordIndex, final String title, final String description, final String workLoad, final String moreInfo) {
		super.signIn("inventor2", "inventor2");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.clickOnButton("Items");

		super.clickOnButton("Create");
		super.fillInputBoxIn("number", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("workLoad", workLoad);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Create");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(quantityRecordIndex, 0, title);
		super.checkColumnHasValue(quantityRecordIndex, 1, workLoad);

		super.clickOnListingRecord(quantityRecordIndex);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("workLoad", workLoad);
		super.checkInputBoxHasValue("moreInfo", moreInfo);

		super.signOut();
	}

}
