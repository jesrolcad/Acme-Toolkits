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
	@CsvFileSource(resources = "/patron/patronage/delete.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positivePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron1", "patron1");
		//list
		super.clickOnMenu("Patron", "List patronages");
//		Integer prev=this.repository.tests();
		super.clickOnListingRecord(recordIndex);
		super.clickOnButton("Publish");
		super.clickOnSubmit("Confirm Publish");
		super.clickOnMenu("Patron", "List patronages");
		super.checkNotErrorsExist();
//		assert prev.equals(this.repository.tests());

		
		super.signOut();
	}

}
