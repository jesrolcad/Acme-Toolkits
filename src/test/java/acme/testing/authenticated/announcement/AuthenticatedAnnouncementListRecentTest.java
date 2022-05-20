package acme.testing.authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TemporalAwareTestHarness;

public class AuthenticatedAnnouncementListRecentTest extends TemporalAwareTestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final int deltaDays, final String body, final String info, final String critical) {
		String moment;
		
		moment = super.computeDeltaMoment(deltaDays);
		super.signIn("inventor1", "inventor1");	
		
		super.clickOnMenu("Authenticated", "List of recent announcements");
 
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, moment);
		super.checkColumnHasValue(recordIndex, 2, body);
		super.checkColumnHasValue(recordIndex, 3, critical);
		
		super.signOut();

	}
	
	@Test
	@Order(20)
	public void negativeTest() {
		// Esto es un listado, asi que no hay datos para casos negativos.
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/authenticated/announcement/list");
		super.checkPanicExists();
	}

	// Ancillary methods ------------------------------------------------------

}