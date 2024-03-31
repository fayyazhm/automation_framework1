package fayyaz.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import fayyaz.abstractcomponenets.AbstractComponenets;

public class cart extends AbstractComponenets {
	
	WebDriver driver;
		
	@FindBy(css=".cartSection h3")
	List<WebElement> dd;
	
	@FindBy(css=".totalRow button")
	WebElement submit;
	
	
	
	public cart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}

	public boolean check(String name) {
		Boolean match=dd.stream().anyMatch(product->product.getText().equalsIgnoreCase(name));
		return match;
	}
	
	public payment checkOut() {
		submit.click();
		return new payment(driver);
	}
	
	

}
