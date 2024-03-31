package fayyaz.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import fayyaz.abstractcomponenets.AbstractComponenets;

public class confirmation extends AbstractComponenets {
	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement conf;

	
	public confirmation(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	
	public String messagecheck() {
		String match=conf.getText();
		return match;
		
	}
	
	

}
