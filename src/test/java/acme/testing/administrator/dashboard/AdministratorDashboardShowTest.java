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
	public void administatorDashboardPositive(final String averageBudgetEURT1,
		final String averageBudgetGBPT1,final String averageBudgetGBPT2,final String averageBudgetUSDT1,
		final String averageBudgetEURT2, final String averageBudgetUSDT3,	
		final String deviationBudgetEURT1,final String deviationBudgetGBPT1,final String deviationBudgetGBPT2,final String deviationBudgetUSDT1,
		final String deviationBudgetEURT2,final String deviationBudgetUSDT3,
		final String minBudgetEURT1,final String minBudgetGBPT1,final String minBudgetGBPT2,final String minBudgetUSDT1,
		final String minBudgetEURT2,final String minBudgetUSDT3,
		final String maxBudgetEURT1,final String maxBudgetGBPT1,final String maxBudgetGBPT2,final String maxBudgetUSDT1,
		final String maxBudgetEURT2,final String maxBudgetUSDT3,
		
		
		final String averageBToolEUR, final String averageBToolGBP,final String averageBToolUSD,
		final String deviationBToolEUR,final String deviationBToolGBP,final String deviationBToolUSD,
		final String minBToolEUR,final String minBToolGBP,final String minBToolUSD,final String maxBToolEUR,final String maxBToolGBP,final String maxBToolUSD,
		
		final String averageRPDenied,final String averageRPAccepted,final String averageRPProposed,
		final String deviationRPDenied,final String deviationRPAccepted,final String deviationRPProposed,
		final String minBRPDenied,final String minBRPAccepted,final String minBRPProposed,
		final String maxBRPDenied,final String maxBRPAccepted,final String maxBRPProposed,
		
		final String totalProposedPatronages,final String totalAcceptedPatronages,final String totalDeniedPatronages, final String totalComponents,final String totalTools) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
	
		BrowserDriver driver= super.getDriver();
		//components
		WebElement averageByBudgetEURT1 = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement averageByBudgetGBPT1 = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement averageByBudgetGBPT2 = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(2)"));
		WebElement averageByBudgetUSDT1 = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(3) > tr:nth-child(4) > td:nth-child(2)"));
		WebElement averageByBudgetEURT2 = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(3) > tr:nth-child(5) > td:nth-child(2)"));
		WebElement averageByBudgetUSDT3 = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(3) > tr:nth-child(6) > td:nth-child(2)"));
		assert averageBudgetEURT1.equals(averageByBudgetEURT1.getText());
		assert averageBudgetGBPT1.equals(averageByBudgetGBPT1.getText());
		assert averageBudgetGBPT2.equals(averageByBudgetGBPT2.getText());
		assert averageBudgetUSDT1.equals(averageByBudgetUSDT1.getText());
		assert averageBudgetEURT2.equals(averageByBudgetEURT2.getText());
		assert averageBudgetUSDT3.equals(averageByBudgetUSDT3.getText());
		
		WebElement deviationByBudgetEURT1 = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement deviationByBudgetGBPT1 = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement deviationByBudgetGBPT2 = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(2)"));
		WebElement deviationByBudgetUSDT1 = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(4) > td:nth-child(2)"));
		WebElement deviationByBudgetEURT2 = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(5) > td:nth-child(2)"));
		WebElement deviationByBudgetUSDT3 = driver.locateOne(By.cssSelector("table.table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(6) > td:nth-child(2)"));
		assert deviationBudgetEURT1.equals(deviationByBudgetEURT1.getText());
		assert deviationBudgetGBPT1.equals(deviationByBudgetGBPT1.getText());
		assert deviationBudgetGBPT2.equals(deviationByBudgetGBPT2.getText());
		assert deviationBudgetUSDT1.equals(deviationByBudgetUSDT1.getText());
		assert deviationBudgetEURT2.equals(deviationByBudgetEURT2.getText());
		assert deviationBudgetUSDT3.equals(deviationByBudgetUSDT3.getText());
		
		
		WebElement minByBudgetEURT1 = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement minByBudgetGBPT1 = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement minByBudgetGBPT2 = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
		WebElement minByBudgetUSDT1 = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"));
		WebElement minByBudgetEURT2 = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"));
		WebElement minByBudgetUSDT3 = driver.locateOne(By.cssSelector("table.table:nth-child(7) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)"));
		assert minBudgetEURT1.equals(minByBudgetEURT1.getText());
		assert minBudgetGBPT1.equals(minByBudgetGBPT1.getText());
		assert minBudgetGBPT2.equals(minByBudgetGBPT2.getText());
		assert minBudgetUSDT1.equals(minByBudgetUSDT1.getText());
		assert minBudgetEURT2.equals(minByBudgetEURT2.getText());
		assert minBudgetUSDT3.equals(minByBudgetUSDT3.getText());
		
		WebElement maxByBudgetEURT1 = driver.locateOne(By.cssSelector("table.table:nth-child(8) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement maxByBudgetGBPT1 = driver.locateOne(By.cssSelector("table.table:nth-child(8) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement maxByBudgetGBPT2 = driver.locateOne(By.cssSelector("table.table:nth-child(8) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
		WebElement maxByBudgetUSDT1 = driver.locateOne(By.cssSelector("table.table:nth-child(8) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"));
		WebElement maxByBudgetEURT2 = driver.locateOne(By.cssSelector("table.table:nth-child(8) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"));
		WebElement maxByBudgetUSDT3 = driver.locateOne(By.cssSelector("table.table:nth-child(8) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)"));
		assert maxBudgetEURT1.equals(maxByBudgetEURT1.getText());
		assert maxBudgetGBPT1.equals(maxByBudgetGBPT1.getText());
		assert maxBudgetGBPT2.equals(maxByBudgetGBPT2.getText());
		assert maxBudgetUSDT1.equals(maxByBudgetUSDT1.getText());
		assert maxBudgetEURT2.equals(maxByBudgetEURT2.getText());
		assert maxBudgetUSDT3.equals(maxByBudgetUSDT3.getText());
		


//		tools
		
		WebElement averageBuToolEUR = driver.locateOne(By.cssSelector("table.table:nth-child(10) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement averageBuToolGBP = driver.locateOne(By.cssSelector("table.table:nth-child(10) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement averageBuToolUSD = driver.locateOne(By.cssSelector("table.table:nth-child(10) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
		
		assert averageBToolEUR.equals(averageBuToolEUR.getText());
		assert averageBToolGBP.equals(averageBuToolGBP.getText());
		assert averageBToolUSD.equals(averageBuToolUSD.getText());
		
		WebElement deviationBuToolEUR = driver.locateOne(By.cssSelector("table.table:nth-child(11) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement deviationBuToolGBP = driver.locateOne(By.cssSelector("table.table:nth-child(11) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement deviationBuToolUSD = driver.locateOne(By.cssSelector("table.table:nth-child(11) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
		
		assert deviationBToolEUR.equals(deviationBuToolEUR.getText());
		assert deviationBToolGBP.equals(deviationBuToolGBP.getText());
		assert deviationBToolUSD.equals(deviationBuToolUSD.getText());
		
		WebElement minBuToolEUR = driver.locateOne(By.cssSelector("table.table:nth-child(12) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement minBuToolGBP = driver.locateOne(By.cssSelector("table.table:nth-child(12) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement minBuToolUSD = driver.locateOne(By.cssSelector("table.table:nth-child(12) > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(2)"));
		
		assert minBToolEUR.equals(minBuToolEUR.getText());
		assert minBToolGBP.equals(minBuToolGBP.getText());
		assert minBToolUSD.equals(minBuToolUSD.getText());
		
		WebElement maxBuToolEUR = driver.locateOne(By.cssSelector("table.table:nth-child(13) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement maxBuToolGBP = driver.locateOne(By.cssSelector("table.table:nth-child(13) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement maxBuToolUSD = driver.locateOne(By.cssSelector("table.table:nth-child(13) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
		
		assert maxBToolEUR.equals(maxBuToolEUR.getText());
		assert maxBToolGBP.equals(maxBuToolGBP.getText());
		assert maxBToolUSD.equals(maxBuToolUSD.getText());




//PATRONAGES
		
		
		
		WebElement deviationRPatDenied = driver.locateOne(By.cssSelector("table.table:nth-child(16) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement deviationRPatAccepted = driver.locateOne(By.cssSelector("table.table:nth-child(16) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement deviationRPatProposed = driver.locateOne(By.cssSelector("table.table:nth-child(16) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));

		
		assert deviationRPDenied.equals(deviationRPatDenied.getText());
		assert deviationRPAccepted.equals(deviationRPatAccepted.getText());
		assert deviationRPProposed.equals(deviationRPatProposed.getText());

		WebElement minBRPatDenied = driver.locateOne(By.cssSelector("table.table:nth-child(17) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement minBRPatAccepted = driver.locateOne(By.cssSelector("table.table:nth-child(17) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement minBRPatProposed = driver.locateOne(By.cssSelector("table.table:nth-child(17) > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(2)"));

		
		assert minBRPDenied.equals(minBRPatDenied.getText());
		assert minBRPAccepted.equals(minBRPatAccepted.getText());
		assert minBRPProposed.equals(minBRPatProposed.getText());
		

		WebElement maxBRPatDenied = driver.locateOne(By.cssSelector("table.table:nth-child(18) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
		WebElement maxBRPatAccepted = driver.locateOne(By.cssSelector("table.table:nth-child(18) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement maxBRPatProposed = driver.locateOne(By.cssSelector("table.table:nth-child(18) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));

		
		assert maxBRPDenied.equals(maxBRPatDenied.getText());
		assert maxBRPAccepted.equals(maxBRPatAccepted.getText());
		assert maxBRPProposed.equals(maxBRPatProposed.getText());

		//Total
		WebElement totalNumberOfTools = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(3) > tr:nth-child(5) > td:nth-child(2)"));
		WebElement totalNumberOfComponents = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(3) > tr:nth-child(4) > td:nth-child(2)"));
		WebElement totalNumberOfDeniedPatronages = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(2)"));
		WebElement totalNumberOfAcceptedPatronages = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2)"));
		WebElement totalNumberOfProposedPatronages = driver.locateOne(By.cssSelector("table.table:nth-child(19) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)"));
		
		assert totalProposedPatronages.equals(totalNumberOfProposedPatronages.getText());
		assert totalAcceptedPatronages.equals(totalNumberOfAcceptedPatronages.getText());
		assert totalDeniedPatronages.equals(totalNumberOfDeniedPatronages.getText());
		assert totalTools.equals(totalNumberOfTools.getText());
		assert totalComponents.equals(totalNumberOfComponents.getText());
		

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administatorHackingTest() {
		super.signIn("inventor1", "inventor1");
		super.navigate("/administrator/administrator-dashboard/show");
		super.checkErrorsExist();
		
		super.signOut();
		super.signIn("patron1", "patron1");
		super.navigate("/administrator/administrator-dashboard/show");
		super.checkErrorsExist();
		
		super.signOut();
	
		
	}
}
