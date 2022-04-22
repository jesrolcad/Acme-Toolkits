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

	public void PatronDashboardShowTest(final String deviationEURACCEPTED,final String deviationUSDPROPOSED, final String deviationEURDENIED, final String deviationGBPDENIED,
		final String minEURACCEPTED,final String minUSDPROPOSED,final String minEURDENIED,final String minGBPDENIED,final String maxEURACCEPTED,final String maxUSDPROPOSED,final String maxEURDENIED,final String maxGBPDENIED,
		final String totalPROPOSED,final String totalACCEPTED,final String totalDENIED) {
	super.signIn("patron1", "patron1");
	super.clickOnMenu("Patron", "Dashboard");

	BrowserDriver driver= super.getDriver();
	WebElement deviationByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement deviationByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement deviationByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement deviationByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)"));
	assert deviationEURACCEPTED.equals(deviationByEURACCEPTED.getText());
	assert deviationUSDPROPOSED.equals(deviationByUSDPROPOSED.getText());
	assert deviationEURDENIED.equals(deviationByEURDENIED.getText());
	assert deviationGBPDENIED.equals(deviationByGBPDENIED.getText());
	WebElement minByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement minByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement minByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement minByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)"));
	
	WebElement maxByEURACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement maxByUSDPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement maxByEURDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
	WebElement maxByGBPDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)"));

	assert minEURACCEPTED.equals(minByEURACCEPTED.getText());
	assert minUSDPROPOSED.equals(minByUSDPROPOSED.getText());
	assert minEURDENIED.equals(minByEURDENIED.getText());
	assert minGBPDENIED.equals(minByGBPDENIED.getText());
	assert maxEURACCEPTED.equals(maxByEURACCEPTED.getText());
	assert maxUSDPROPOSED.equals(maxByUSDPROPOSED.getText());
	assert maxEURDENIED.equals(maxByEURDENIED.getText());
	assert maxGBPDENIED.equals(maxByGBPDENIED.getText());
	WebElement totalBYPROPOSED = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
	WebElement totalBYACCEPTED = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
	WebElement totalBYDENIED = driver.locateOne(By.cssSelector("table.table:nth-child(5) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)"));
	
	assert totalPROPOSED.equals(totalBYPROPOSED.getText());
	assert totalACCEPTED.equals(totalBYACCEPTED.getText());
	assert totalDENIED.equals(totalBYDENIED.getText());

	
	}}