package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.TestNGCreation;

public class FooterLinkValidationElementFactory extends TestNGCreation{
	
	
//	@FindBy(xpath = "(//table[@class='gf-t']//ul)[1]/li")
//	public static List<WebElement> footerLinks;
//	
	@FindBy(xpath = "//h1[text()='Practice Page']")
	public static WebElement practicePageLabel;
}
