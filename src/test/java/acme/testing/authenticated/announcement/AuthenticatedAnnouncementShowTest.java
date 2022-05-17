package acme.testing.authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TemporalAwareTestHarness;

public class AuthenticatedAnnouncementShowTest extends TemporalAwareTestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/show-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final int deltaDays, final String body, final String info, final String critical) {
		String moment;
		
		moment = super.computeDeltaMoment(deltaDays);
		super.signIn("inventor1", "inventor1");	
		
		super.clickOnMenu("Authenticated", "List of recent announcements");
 
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("info", info);
		super.checkInputBoxHasValue("critical", critical);
		super.signOut();

	}
	@Test
	@Order(20)
	public void negativeTest() {
		//Esto es un show, asi que no deberia de tener tests con casos negativos
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