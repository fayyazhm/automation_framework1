package fayyaz.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import fayyaz.abstractcomponenets.AbstractComponenets;

public class payment extends AbstractComponenets {
	
//	Actions a=new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "ind").build().perform();
//	wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	List<WebElement> ld=driver.findElements(By.cssSelector(".ta-item"));
//	System.out.println(ld);
//	for(WebElement cv:ld) {
//		System.out.println(cv);
//		String cit=cv.findElement(By.cssSelector("span[class='ng-star-inserted']")).getText();
//		if (cit.equalsIgnoreCase("india")) {
//			cv.findElement(By.cssSelector("span[class='ng-star-inserted']")).click();
//			break;
//		}
//	}
//	
//	

	WebDriver driver;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countrylist;
	
	@FindBy(css=".ta-results")
	WebElement ld;
	
	@FindBy(css=".ta-item")
	List<WebElement> lis;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By countr=By.cssSelector(".ta-results");
	By countrsel=By.cssSelector("span[class='ng-star-inserted']");
	By countryclic=By.cssSelector("span[class='ng-star-inserted']");
	
	public payment(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void selectCountry(String name) {
		
		Actions a =new Actions(driver);
		a.sendKeys(countrylist,name).build().perform();
		waitforelement(countr);
		for(WebElement cv:lis) {
		System.out.println(cv);
		String cit=cv.findElement(countrsel).getText();
		if (cit.equalsIgnoreCase("india")) {
			cv.findElement(countryclic).click();
			break;
		}
	}
	}

	public confirmation gotoconfirmation() {
		submit.click();
		return new confirmation(driver);
		
	}

}
