package acme.testing.patron.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronDashboardShowTest  extends TestHarness {
	// descomentar si no funciona	@SuppressWarnings("unlikely-arg-type")

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)

	public void patronDashboardShowTest(
		final String averageBudgetEURACCEPTED,final String averageBudgetUSDPROPOSED,final String averageBudgetEURDENIED,final String averageBudgetGBPPROPOSED
		,final String averageBudgetEURPROPOSED,final String averageBudgetGBPDENIED,final String averageBudgetUSDACCEPTED,
		final String deviationBudgetEURACCEPTED,final String deviationBudgetUSDPROPOSED,final String deviationBudgetEURDENIED,final String deviationBudgetGBPPROPOSED
		,final String deviationBudgetEURPROPOSED,final String deviationBudgetGBPDENIED,final String deviationBudgetUSDACCEPTED,
		final String minBudgetEURACCEPTED,final String minBudgetUSDPROPOSED,final String minBudgetEURDENIED,final String minBudgetGBPPROPOSED
		,final String minBudgetEURPROPOSED,final String minBudgetGBPDENIED,final String minBudgetUSDACCEPTED,
		final String maxBudgetEURACCEPTED,final String maxBudgetUSDPROPOSED,final String maxBudgetEURDENIED,final String maxBudgetGBPPROPOSED
		,final String maxBudgetEURPROPOSED,final String maxBudgetGBPDENIED,final String maxBudgetUSDACCEPTED,
		final String totalPROPOSED,final String totalACCEPTED,final String totalDENIED) {
	super.signIn("patron1", "patron1");
	super.clickOnMenu("Patron", "Dashboard");

	BrowserDriver driver= super.getDriver();
	WebElement averageBudgetByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement averageBudgetByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement averageBudgetByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement averageBudgetByGBPPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"));	
	WebElement averageBudgetByEURPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"));
	WebElement averageBudgetByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)"));
	WebElement averageBudgetByUSDACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)"));

	assert averageBudgetEURACCEPTED.equals(averageBudgetByEURACCEPTED.getText());
	assert averageBudgetUSDPROPOSED.equals(averageBudgetByUSDPROPOSED.getText());
	assert averageBudgetEURDENIED.equals(averageBudgetByEURDENIED.getText());
	assert averageBudgetGBPPROPOSED.equals(averageBudgetByGBPPROPOSED.getText());
	assert averageBudgetEURPROPOSED.equals(averageBudgetByEURPROPOSED.getText());
	assert averageBudgetGBPDENIED.equals(averageBudgetByGBPDENIED.getText());
	assert averageBudgetUSDACCEPTED.equals(averageBudgetByUSDACCEPTED.getText());
	
	WebElement deviationBudgetByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement deviationBudgetByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement deviationBudgetByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement deviationBudgetByGBPPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"));	
	WebElement deviationBudgetByEURPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"));
	WebElement deviationBudgetByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)"));
	WebElement deviationBudgetByUSDACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)"));

	assert deviationBudgetEURACCEPTED.equals(deviationBudgetByEURACCEPTED.getText());
	assert deviationBudgetUSDPROPOSED.equals(deviationBudgetByUSDPROPOSED.getText());
	assert deviationBudgetEURDENIED.equals(deviationBudgetByEURDENIED.getText());
	assert deviationBudgetGBPPROPOSED.equals(deviationBudgetByGBPPROPOSED.getText());
	assert deviationBudgetEURPROPOSED.equals(deviationBudgetByEURPROPOSED.getText());
	assert deviationBudgetGBPDENIED.equals(deviationBudgetByGBPDENIED.getText());
	assert deviationBudgetUSDACCEPTED.equals(deviationBudgetByUSDACCEPTED.getText());
	
	WebElement minBudgetByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement minBudgetByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement minBudgetByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement minBudgetByGBPPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"));	
	WebElement minBudgetByEURPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"));
	WebElement minBudgetByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)"));
	WebElement minBudgetByUSDACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)"));

	assert minBudgetEURACCEPTED.equals(minBudgetByEURACCEPTED.getText());
	assert minBudgetUSDPROPOSED.equals(minBudgetByUSDPROPOSED.getText());
	assert minBudgetEURDENIED.equals(minBudgetByEURDENIED.getText());
	assert minBudgetGBPPROPOSED.equals(minBudgetByGBPPROPOSED.getText());
	assert minBudgetEURPROPOSED.equals(minBudgetByEURPROPOSED.getText());
	assert minBudgetGBPDENIED.equals(minBudgetByGBPDENIED.getText());
	assert minBudgetUSDACCEPTED.equals(minBudgetByUSDACCEPTED.getText());
	
	WebElement maxBudgetByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement maxBudgetByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement maxBudgetByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement maxBudgetByGBPPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"));	
	WebElement maxBudgetByEURPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"));
	WebElement maxBudgetByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(6) > td:nth-child(2)"));
	WebElement maxBudgetByUSDACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(2) > tr:nth-child(7) > td:nth-child(2)"));

	assert maxBudgetEURACCEPTED.equals(maxBudgetByEURACCEPTED.getText());
	assert maxBudgetUSDPROPOSED.equals(maxBudgetByUSDPROPOSED.getText());
	assert maxBudgetEURDENIED.equals(maxBudgetByEURDENIED.getText());
	assert maxBudgetGBPPROPOSED.equals(maxBudgetByGBPPROPOSED.getText());
	assert maxBudgetEURPROPOSED.equals(maxBudgetByEURPROPOSED.getText());
	assert maxBudgetGBPDENIED.equals(maxBudgetByGBPDENIED.getText());
	assert maxBudgetUSDACCEPTED.equals(maxBudgetByUSDACCEPTED.getText());


	WebElement totalBYPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement totalBYACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement totalBYDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"));
	
	assert totalPROPOSED.equals(totalBYPROPOSED.getText());
	assert totalACCEPTED.equals(totalBYACCEPTED.getText());
	assert totalDENIED.equals(totalBYDENIED.getText());

	
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void administatorHackingTest() {
		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patron-dashboard/show");
		super.checkErrorsExist();			
	
		
	}	
}