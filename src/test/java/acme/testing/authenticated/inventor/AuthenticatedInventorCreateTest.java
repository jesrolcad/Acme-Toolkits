package acme.testing.authenticated.inventor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedInventorCreateTest extends TestHarness{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/inventor/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positiveInventorCreate(final int recordIndex,final String company, final String statement, final String link) {
		
		
		super.signUp("testInventor"+recordIndex, "complexPassword", "test","test","test@acme.us");
		super.signIn("testInventor"+recordIndex, "complexPassword");
		
		super.clickOnMenu("Account", "Become an inventor");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");
		
		super.clickOnMenu("Account", "Inventor data");

		super.checkInputBoxHasValue("company", company);
		super.checkInputBoxHasValue("statement", statement);
		super.checkInputBoxHasValue("link", link);
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/inventor/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(2)
	public void negativeInventorCreate(final int recordIndex,final String company, final String statement, final String link) {
		
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