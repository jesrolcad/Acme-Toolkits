package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
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
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + itemId +"]")).click();
		
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
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeFormTest(final int toolkitRecordIndex, final String number, final String itemId) {
		super.signIn("inventor2", "inventor2");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.clickOnButton("Items");

		super.clickOnButton("Add new item");
		super.fillInputBoxIn("number", number);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + itemId +"]")).click();
		super.clickOnSubmit("Add");
		super.checkErrorsExist();

		super.signOut();
	}
	
	//Este test prueba que no se pueden añadir items a una toolkit ya publicada
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/create-negative-button.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeButtonTest(final int toolkitRecordIndex, final String published) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("published", published);
		super.clickOnButton("Items");

		super.checkNotButtonExists("Add new item");
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.navigate("/inventor/quantity/create");
		super.checkPanicExists();

		super.signIn("patron1", "patron1");
		super.navigate("/inventor/quantity/create");
		super.checkPanicExists();
		super.signOut();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/quantity/create");
		super.checkPanicExists();
		super.signOut();
	}
	
	
	
	

}
