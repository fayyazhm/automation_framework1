package fayyaz.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import fayyaz.abstractcomponenets.AbstractComponenets;

public class order extends AbstractComponenets {
	
	WebDriver driver;
		
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderedlist;
		
	public order(WebDriver driver) {
		super(driver);	
		this.driver=driver; 
		PageFactory.initElements(driver, this );
	}
	
	public boolean verifyProductDisplay(String name) {
		Boolean match=orderedlist.stream().anyMatch(product->product.getText().equalsIgnoreCase(name));
		return match;
	}
	
	
	
	

}
