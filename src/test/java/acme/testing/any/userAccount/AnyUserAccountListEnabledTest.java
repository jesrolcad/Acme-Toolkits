package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountListEnabledTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousPositive(final int recordIndex, final String roles, 
		final String username, final String name, final String surname, final String email) {
		

		super.clickOnMenu("Any", "List enabled user accounts");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, roles);
		super.checkColumnHasValue(recordIndex, 1, username);
		super.checkColumnHasValue(recordIndex, 2, email);

	}
	
	

}
