package fayyaz.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fayyaz.abstractcomponenets.AbstractComponenets;

public class LandingPage extends AbstractComponenets {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
//	WebElement username=driver.findElement(By.id("userEmail"));
//	WebElement pass=driver.findElement(By.id("userPassword"));
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;

	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormess;
	
	By landingerror=By.cssSelector("[class*='flyInOut']");
	
	public ProductCatalogue loginapplication(String email,String pass) {
		username.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		return new ProductCatalogue(driver);
	}
	
	public String getErrorMessage() {
		waitforelement(landingerror);
		String cc=errormess.getText();
		return cc;
	} 
	
	public void go(String url) {
		driver.get(url);
	}

}
