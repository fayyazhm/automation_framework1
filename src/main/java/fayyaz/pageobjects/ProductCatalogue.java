package fayyaz.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import fayyaz.abstractcomponenets.AbstractComponenets;

public class ProductCatalogue extends AbstractComponenets {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
	
	@FindBy(css="div.mb-3")
	List<WebElement> lis;
	
	By Productsby=By.cssSelector("div.mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	By animat=By.cssSelector(".ng-animating");
	
	public List<WebElement> getproductlist() {
		waitforelement(Productsby);
		return lis;
	}
	
	public WebElement getproductbyname(String productname) {
		WebElement d=getproductlist().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		System.out.println(d);
		System.out.println(d.getText());
		return d;
	}

	public void addproducttocart(String productname) {

		WebElement c=getproductbyname(productname);
		c.findElement(addToCart).click();
		waitforelement(toastmessage);
		waitforelementdisappear(animat);
		
	} 
	
}
