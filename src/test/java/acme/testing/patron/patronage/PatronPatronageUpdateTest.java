package acme.testing.patron.patronage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageUpdateTest extends TestHarness{
    LocalDateTime currentLocalDateTimeStart = LocalDateTime.now().plusMonths(2);
    LocalDateTime currentLocalDateTimeEnd = LocalDateTime.now().plusMonths(4);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String formattedDateTimeStart = this.currentLocalDateTimeStart.format(this.dateTimeFormatter);
    String formattedDateTimeEND = this.currentLocalDateTimeEnd.format(this.dateTimeFormatter);
    
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron3", "patron3");
		//list
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("code", code);
		
		super.fillInputBoxIn("startDate",this.formattedDateTimeStart );
		super.fillInputBoxIn("endDate", this.formattedDateTimeEND);
		super.fillInputBoxIn("legalStuff", legal_stuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Update");
		super.clickOnMenu("Patron", "List patronages");

		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("startDate", this.formattedDateTimeStart);
		super.checkInputBoxHasValue("endDate", this.formattedDateTimeEND);
		super.checkInputBoxHasValue("legalStuff", legal_stuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("link", link);

		
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron3", "patron3");
//list
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("startDate",this.formattedDateTimeStart );
		super.fillInputBoxIn("endDate", this.formattedDateTimeEND);
		super.fillInputBoxIn("legalStuff", legal_stuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Update");
		super.checkErrorsExist();
		super.signOut();
	}
	
	

	// Ancillary methods ------------------------------------------------------

}
