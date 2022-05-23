package acme.testing.patron.patronage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronagePublishTest extends TestHarness{
//	@Autowired 
//	protected PatronPatronageRepository repository;
	
    LocalDateTime currentLocalDateTimeStart = LocalDateTime.now().plusMonths(2);
    LocalDateTime currentLocalDateTimeEnd = LocalDateTime.now().plusMonths(4);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String formattedDateTimeStart = this.currentLocalDateTimeStart.format(this.dateTimeFormatter);
    String formattedDateTimeEND = this.currentLocalDateTimeEnd.format(this.dateTimeFormatter);
    
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status,final String published, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron4", "patron4");
		super.clickOnMenu("Patron", "List patronages");
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		super.clickOnMenu("Patron", "List patronages");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("published", published);
		super.checkNotErrorsExist();

		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void negativePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status,final String published, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkNotButtonExists("Publish");

		
		super.signOut();
	}
	
	

}
