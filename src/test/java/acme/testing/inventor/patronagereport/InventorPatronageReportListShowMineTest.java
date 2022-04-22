package acme.testing.inventor.patronagereport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListShowMineTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String seq_number,final String creation_moment,final String memorandum,final String link) {
		
		
		super.signIn("inventor1", "inventor1");
		//list
		super.clickOnMenu("Inventor", "Patronage reports");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, seq_number);
		super.checkColumnHasValue(recordIndex, 1, creation_moment);
		super.checkColumnHasValue(recordIndex, 2, link);
		
		//show
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("sequenceNumber", seq_number);
		super.checkInputBoxHasValue("creationMoment", creation_moment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
