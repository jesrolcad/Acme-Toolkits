package acme.testing.inventor.patronagereport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/createPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(2)
	public void positivePatronage(final int recordIndex, final String memorandum,final String link) {
		
		
		super.signIn("inventor1", "inventor1");
	
		super.clickOnMenu("Inventor", "List patronages");
		//show
		super.clickOnListingRecord(0);
		super.clickOnButton("Create Report");
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create");
		super.clickOnMenu("Inventor", "Patronage reports");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);
		


		

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/createNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativePatronage(final int recordIndex, final String memorandum,final String link,final String confirmation) {
		
		
		super.signIn("inventor1", "inventor1");
	
		super.clickOnMenu("Inventor", "List patronages");
		//show
		super.clickOnListingRecord(recordIndex);
		super.clickOnButton("Create Report");
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation",confirmation);
		super.clickOnSubmit("Create");
		super.checkErrorsExist();
	}
	


	// Ancillary methods ------------------------------------------------------

}
