package acme.testing.patron.patronage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageDeleteTest extends TestHarness{
//	@Autowired 
//	protected PatronPatronageRepository repository;
	
    LocalDateTime currentLocalDateTimeStart = LocalDateTime.now().plusMonths(2);
    LocalDateTime currentLocalDateTimeEnd = LocalDateTime.now().plusMonths(4);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String formattedDateTimeStart = this.currentLocalDateTimeStart.format(this.dateTimeFormatter);
    String formattedDateTimeEND = this.currentLocalDateTimeEnd.format(this.dateTimeFormatter);
    
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron4", "patron4");
		//list
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, budget);
		super.checkColumnHasValue(recordIndex, 2, start_date);
		super.checkColumnHasValue(recordIndex, 3, end_date);
		super.checkColumnHasValue(recordIndex, 4, status);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("startDate", start_date);
		super.checkInputBoxHasValue("endDate", end_date);
		super.checkInputBoxHasValue("legalStuff", legal_stuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("link", link);
		super.clickOnSubmit("Delete patronage");
		super.checkNotErrorsExist();
		
		super.clickOnMenu("Patron", "List patronages");
		super.checkNotErrorsExist();

		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String published, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("startDate", start_date);
		super.checkInputBoxHasValue("endDate", end_date);
		super.checkInputBoxHasValue("legalStuff", legal_stuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("published", published);
		super.checkInputBoxHasValue("link", link);
		super.checkNotSubmitExists("Delete patronage");
		
		super.signOut();
	}

}
