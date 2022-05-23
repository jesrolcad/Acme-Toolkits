package acme.testing.patron.patronagereport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageReportListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronageReport/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String seq_number,final String creation_moment,final String link) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "Patronage reports");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, seq_number);
		super.checkColumnHasValue(recordIndex, 1, creation_moment);
		super.checkColumnHasValue(recordIndex, 2, link);
		
		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage-report/list");
		super.checkPanicExists();
	}
}
