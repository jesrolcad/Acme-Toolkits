package acme.testing.inventor.patronagereport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String seq_number,final String creation_moment,final String memorandum,final String link) {
		
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "Patronage reports");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, seq_number);
		super.checkColumnHasValue(recordIndex, 1, creation_moment);
		super.checkColumnHasValue(recordIndex, 2, link);


		super.signOut();
	}
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Inventor");
		super.navigate("/inventor/patronage-report/list");
		super.checkPanicExists();
	}
	// Ancillary methods ------------------------------------------------------

}
