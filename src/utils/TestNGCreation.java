package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.github.dockerjava.api.model.Config;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.FooterLinkValidationPage;



public class TestNGCreation{
	
	public static FooterLinkValidationPage footerLinkValidationPage;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	protected WebDriver driver;
	Properties prop=new Properties();
	
	public BrowserFactory br=new BrowserFactory();
	
	@BeforeSuite
	public void beforeSuite() {
		String timeStamp=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
		report=new ExtentReports(System.getProperty("user.dir")+"\\src\\reports\\"+timeStamp+".html");
		report.addSystemInfo("Host Name", timeStamp);
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws FileNotFoundException {
		driver=br.startBrowser("chrome");
		//instantiating pageClasses
		footerLinkValidationPage = PageFactory.initElements(driver, FooterLinkValidationPage.class);
		
		
		
		String path=System.getProperty("user.dir")+"\\src\\configuration\\config.properties";
		FileInputStream fis=new FileInputStream(path);
		//br.startBrowser(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void afterMathod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Failed!");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() throws Exception {
		report.close();
	}
	
}
