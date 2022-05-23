package acme.testing.authenticated.patron;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedPatronCreateTest extends TestHarness{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/patron/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positivePatronCreate(final int recordIndex,final String company, final String statement, final String link) {
		
		
		super.signUp("testPatron"+recordIndex, "complexPassword", "test","test","test@acme.us");
		super.signIn("testPatron"+recordIndex, "complexPassword");
		
		super.clickOnMenu("Account", "Become a patron");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");
		
		super.clickOnMenu("Account", "Patron data");

		super.checkInputBoxHasValue("company", company);
		super.checkInputBoxHasValue("statement", statement);
		super.checkInputBoxHasValue("link", link);
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/patron/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(2)
	public void negativePatronCreate(final int recordIndex,final String company, final String statement, final String link) {
		
		super.signUp("testPatron"+recordIndex, "complexPassword", "test","test","test@acme.us");
		super.signIn("testPatron"+recordIndex, "complexPassword");
		
		super.clickOnMenu("Account", "Become a patron");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");

		super.checkErrorsExist();
		super.signOut();
	}
	

}