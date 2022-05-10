package acme.testing.any.chirp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.core.annotation.Order;

import acme.testing.TestHarness;

public class AnyChirpCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String title, final String body, 
		final String author, final String email, final String confirmation) {
		
		super.clickOnMenu("Any", "List recent chirps");
		super.clickOnButton("Create");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.clickOnMenu("Any", "List of recent chirps");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 2, body);
		super.checkColumnHasValue(recordIndex, 3, author);
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("info", author);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("confirmation", confirmation);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String title, final String body, 
		final String author, final String email, final String confirmation) {
		

		super.clickOnMenu("Any", "List recent chirps");
		super.clickOnButton("Create");
		super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();

	}
	

}