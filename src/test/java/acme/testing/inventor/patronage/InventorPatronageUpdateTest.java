package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorPatronageUpdateTest extends TestHarness {

	@Test
	@Order(1)
	public void positivePatronage() {
		
		
		super.signIn("inventor2", "inventor2");
		//list
		super.clickOnMenu("Inventor", "List proposed patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.fillInputBoxIn("status", "ACCEPTED");
		super.clickOnSubmit("Update status");
		super.clickOnListingRecord(0);
		super.fillInputBoxIn("status", "DENIED");
		super.clickOnSubmit("Update status");
		super.clickOnMenu("Inventor", "List accepted and denied patronages");

		super.clickOnListingRecord(0);
		super.checkInputBoxHasValue("status", "ACCEPTED");
		super.clickOnMenu("Inventor", "List accepted and denied patronages");
		super.clickOnListingRecord(1);
		super.checkInputBoxHasValue("status", "DENIED");


		
		super.signOut();
	}
	
}
