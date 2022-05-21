package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class InventorQuantityCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex, final int quantityRecordIndex, final String number,
		final String itemId,final String type, final String name, final String retailPrice, final String itemCode, final String toolkitCode) {
		
		super.signIn("inventor2", "inventor2");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkFormExists();

		super.clickOnButton("Items");
		super.checkListingExists();
		
		super.clickOnButton("Add new item");
		super.fillInputBoxIn("number", number);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId\"]/option[" + itemId +"]")).click();
		
		super.clickOnSubmit("Add");
		
		super.checkNotErrorsExist();
		super.checkListingExists();
		super.checkColumnHasValue(quantityRecordIndex, 3, number);
		
		super.checkListingExists();
		super.sortListing(3, "asc");
		super.checkColumnHasValue(quantityRecordIndex, 0, type);
		super.checkColumnHasValue(quantityRecordIndex, 1, name);
		super.checkColumnHasValue(quantityRecordIndex, 2, retailPrice);
		super.checkColumnHasValue(quantityRecordIndex, 3, number);
		super.clickOnListingRecord(quantityRecordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("number",number);
		super.checkInputBoxHasValue("item.tipo",type);
		super.checkInputBoxHasValue("item.name", name);
		super.checkInputBoxHasValue("item.code",itemCode);
		super.checkInputBoxHasValue("item.retailPrice",retailPrice);
		super.checkInputBoxHasValue("toolkit.code",toolkitCode);

		super.signOut();
	}

}
