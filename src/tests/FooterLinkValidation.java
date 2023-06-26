package tests;

import org.testng.annotations.Test;

import utils.TestNGCreation;

public class FooterLinkValidation extends TestNGCreation{
	
	@Test(enabled = true)
	public void TC1_DiscountCoupons() throws InterruptedException {
		logger=report.startTest(this.getClass().getSimpleName());
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		footerLinkValidationPage.validatePageTitle(driver,logger);
		System.out.println("Test Completed");
	}
	
}