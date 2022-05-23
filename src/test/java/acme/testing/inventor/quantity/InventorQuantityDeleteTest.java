package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityDeleteTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex, final int quantityRecordIndex, final String number,
		final String type, final String name, final String retailPrice, final String itemCode, final String toolkitCode) {
		
		super.signIn("inventor2", "inventor2");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkFormExists();

		super.clickOnButton("Items");
		super.checkListingExists();
		super.sortListing(1,"asc");
		super.clickOnListingRecord(quantityRecordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("number",number);
		super.checkInputBoxHasValue("item.tipo",type);
		super.checkInputBoxHasValue("item.name", name);
		super.checkInputBoxHasValue("item.code",itemCode);
		super.checkInputBoxHasValue("item.retailPrice",retailPrice);
		super.checkInputBoxHasValue("toolkit.code",toolkitCode);
		
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		super.checkNotPanicExists();

		super.signOut();
	}
	
	//Comprobamos que para las toolkits publicadas no se puede borrar el item
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int toolkitRecordIndex, final String published, final int quantityRecordIndex) {
		
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(toolkitRecordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("published", published);

		super.clickOnButton("Items");
		super.checkListingExists();
		
		super.clickOnListingRecord(quantityRecordIndex);
		super.checkFormExists();
		
		super.checkNotSubmitExists("Delete");

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.navigate("/inventor/quantity/delete");
		super.checkPanicExists();

		super.signIn("patron1", "patron1");
		super.navigate("/inventor/quantity/delete");
		super.checkPanicExists();
		super.signOut();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/quantity/delete");
		super.checkPanicExists();
		super.signOut();
	}
	
	

}
