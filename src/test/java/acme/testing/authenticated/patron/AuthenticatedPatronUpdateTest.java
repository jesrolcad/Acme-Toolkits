package acme.testing.authenticated.patron;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedPatronUpdateTest extends TestHarness{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/patron/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positivePatronUpdate(final int recordIndex,final String company, final String statement, final String link) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Account", "Patron data");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Update");
		
		super.clickOnMenu("Account", "Patron data");

		super.checkInputBoxHasValue("company", company);
		super.checkInputBoxHasValue("statement", statement);
		super.checkInputBoxHasValue("link", link);
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/patron/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(2)
	public void negativePatronUpdate(final int recordIndex,final String company, final String statement, final String link) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Account", "Patron data");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Update");
		super.checkErrorsExist();
		super.signOut();
	}
	

}