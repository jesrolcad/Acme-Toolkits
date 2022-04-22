package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class AdministratorDashboardShowTest extends TestHarness {
// descomentar si no funciona	@SuppressWarnings("unlikely-arg-type")
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administatorDashboardPositive(final String deviationBudgetGBP,final String deviationBudgetEUR,final String deviationBudgetUSD,
		final String minBudgetGBP,final String minBudgetEUR,final String minBudgetUSD,
		final String maxBudgetGBP,final String maxBudgetEUR,final String maxBudgetUSD,
		final String deviationBToolEUR, final String deviationBToolGBP, final String deviationBToolUSD,
		final String minBToolEUR,final String minBToolGBP,final String minBToolUSD,
		final String maxBToolEUR,final String maxBToolGBP,final String maxBToolUSD,
		final String deviationRPDenied, final String deviationRPAccepted, final String deviationRPProposed,
		final String minBRPDenied,	final String minBRPAccepted,	final String minBRPProposed,
		final String maxBRPDenied,	final String maxBRPAccepted,	final String maxBRPProposed,
		
		final String totalProposedPatronages,final String totalAcceptedPatronages,final String totalDeniedPatronages, final String totalComponents,final String totalTools) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
	
		BrowserDriver driver= super.getDriver();
		//components
		WebElement deviationBGBP = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement deviationBEUR = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement deviationBUSD = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		assert deviationBudgetGBP.equals(deviationBGBP.getText());
		assert deviationBudgetEUR.equals(deviationBEUR.getText());
		assert deviationBudgetUSD.equals(deviationBUSD.getText());
		
		WebElement minBudgetBGBP = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement minBudgetBEUR = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement minBudgetBUSD = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		assert minBudgetGBP.equals(minBudgetBGBP.getText());
		assert minBudgetEUR.equals(minBudgetBEUR.getText());
		assert minBudgetUSD.equals(minBudgetBUSD.getText());

//		tools
		
		//problema en bd
//		WebElement deviationToolBEUR = driver.locateOne(By.cssSelector("table.table:nth-child(11) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
//		WebElement deviationToolBGBP = driver.locateOne(By.cssSelector("table.table:nth-child(11) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
//		WebElement deviationToolBUSD = driver.locateOne(By.cssSelector("table.table:nth-child(11) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
//		
//	
//		assert deviationBToolEUR.equals(deviationToolBEUR.getText());
//		assert deviationBToolGBP.equals(deviationToolBGBP.getText());
//		assert deviationBToolUSD.equals(deviationToolBUSD.getText());
		
		WebElement minBuToolEUR = driver.locateOne(By.cssSelector("table.table:nth-child(12) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement minBuToolGBP = driver.locateOne(By.cssSelector("table.table:nth-child(12) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement minBuToolUSD = driver.locateOne(By.cssSelector("table.table:nth-child(12) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		assert minBToolEUR.equals(minBuToolEUR.getText());
		assert minBToolGBP.equals(minBuToolGBP.getText());
		assert minBToolUSD.equals(minBuToolUSD.getText());
		
		WebElement maxBuToolEUR = driver.locateOne(By.cssSelector("table.table:nth-child(13) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement maxBuToolGBP = driver.locateOne(By.cssSelector("table.table:nth-child(13) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement maxBuToolUSD = driver.locateOne(By.cssSelector("table.table:nth-child(13) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		assert maxBToolEUR.equals(maxBuToolEUR.getText());
		assert maxBToolGBP.equals(maxBuToolGBP.getText());
		assert maxBToolUSD.equals(maxBuToolUSD.getText());

//PATRONAGES
		
		
		
		WebElement deviationRPatDenied = driver.locateOne(By.cssSelector("table.table:nth-child(16) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement deviationRPatAccepted = driver.locateOne(By.cssSelector("table.table:nth-child(16) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement deviationRPatProposed = driver.locateOne(By.cssSelector("table.table:nth-child(16) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		
		assert deviationRPDenied.equals(deviationRPatDenied.getText());
		assert deviationRPAccepted.equals(deviationRPatAccepted.getText());
		assert deviationRPProposed.equals(deviationRPatProposed.getText());

		WebElement minBRPatDenied = driver.locateOne(By.cssSelector("table.table:nth-child(17) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement minBRPatAccepted = driver.locateOne(By.cssSelector("table.table:nth-child(17) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement minBRPatProposed = driver.locateOne(By.cssSelector("table.table:nth-child(17) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		
		assert minBRPDenied.equals(minBRPatDenied.getText());
		assert minBRPAccepted.equals(minBRPatAccepted.getText());
		assert minBRPProposed.equals(minBRPatProposed.getText());
		

		WebElement maxBRPatDenied = driver.locateOne(By.cssSelector("table.table:nth-child(18) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement maxBRPatAccepted = driver.locateOne(By.cssSelector("table.table:nth-child(18) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement maxBRPatProposed = driver.locateOne(By.cssSelector("table.table:nth-child(18) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));

		
		assert maxBRPDenied.equals(maxBRPatDenied.getText());
		assert maxBRPAccepted.equals(maxBRPatAccepted.getText());
		assert maxBRPProposed.equals(maxBRPatProposed.getText());

		//Total
		WebElement totalNumberOfTools = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2)"));
		WebElement totalNumberOfComponents = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)"));
		WebElement totalNumberOfDeniedPatronages = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
		WebElement totalNumberOfAcceptedPatronages = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement totalNumberOfProposedPatronages = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
		
		assert totalProposedPatronages.equals(totalNumberOfProposedPatronages.getText());
		assert totalAcceptedPatronages.equals(totalNumberOfAcceptedPatronages.getText());
		assert totalDeniedPatronages.equals(totalNumberOfDeniedPatronages.getText());
		assert totalTools.equals(totalNumberOfTools.getText());
		assert totalComponents.equals(totalNumberOfComponents.getText());
		

	}
}
