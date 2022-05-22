package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageUpdateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int proposedRecordIndex, final String status, final int acceptedOrDeniedRecordIndex) {
		
		
		super.signIn("inventor2", "inventor2");
		//list
		super.clickOnMenu("Inventor", "List proposed patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(proposedRecordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("status", status);
		super.clickOnSubmit("Update status");
		super.clickOnMenu("Inventor", "List accepted and denied patronages");
		super.checkListingExists();
		super.clickOnListingRecord(acceptedOrDeniedRecordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);


		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int proposedRecordIndex, final String status) {
		
		
		super.signIn("inventor2", "inventor2");
		//list
		super.clickOnMenu("Inventor", "List accepted and denied patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(proposedRecordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);
		super.checkNotSubmitExists("Update status");
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.navigate("/inventor/patronage/update");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/inventor/patronage/update");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/patronage/update");
		super.checkPanicExists();
		super.signOut();
		
		
	}
	
	
	
}
