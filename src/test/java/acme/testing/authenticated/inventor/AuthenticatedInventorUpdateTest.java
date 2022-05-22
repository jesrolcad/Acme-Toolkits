package acme.testing.authenticated.inventor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedInventorUpdateTest extends TestHarness{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/inventor/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positiveInventorUpdate(final int recordIndex,final String company, final String statement, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Account", "Inventor data");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Update");
		
		super.clickOnMenu("Account", "Inventor data");

		super.checkInputBoxHasValue("company", company);
		super.checkInputBoxHasValue("statement", statement);
		super.checkInputBoxHasValue("link", link);
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/inventor/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(2)
	public void negativeInventorUpdate(final int recordIndex,final String company, final String statement, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Account", "Inventor data");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Update");
		super.checkErrorsExist();
		super.signOut();
	}
	

}