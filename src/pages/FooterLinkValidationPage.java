package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.util.IterationEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class FooterLinkValidationPage extends FooterLinkValidationElementFactory{
	@FindBy(xpath = "(//table[@class='gf-t']//ul)[1]/li")
	public static List<WebElement> footerLinks;

	
	public WebDriver validatePageTitle(WebDriver driver,ExtentTest logger) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(practicePageLabel));
		//Thread.sleep(10000);
		int linkCount=footerLinks.size();
		logger.log(LogStatus.INFO, "TotalLinkCount: "+linkCount);
		for(int i=2;i<linkCount;i++) {
			System.out.println("((//table[@class='gf-t']//ul)[1]/li/a)["+i+"]");
			WebElement wb=driver.findElement(By.xpath("((//table[@class='gf-t']//ul)[1]/li/a)["+i+"]"));
			Actions a=new Actions(driver);
			
			a.moveToElement(wb)
			.keyDown(Keys.CONTROL)
			.click()
			.build()
			.perform();
		}
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		while(itr.hasNext()) {
			System.out.println(driver.switchTo().window(itr.next()).getTitle());
		}

//		handles.forEach(h->
//			System.out.println(driver.switchTo().window(h).getTitle())
//		);
		
		return driver;
	}
	
}
