package fayyaz.abstractcomponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fayyaz.pageobjects.cart;
import fayyaz.pageobjects.order;


public class AbstractComponenets {
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart1;
	
	@FindBy(css="[routerlink*='myorders'")
	WebElement orders;
	
	
	public AbstractComponenets(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public cart goToCart() {
		cart1.click();
		return new cart(driver);
	}
	
	public order goToOrderPage() {
		orders.click();
		order ord=new order(driver);
		return ord;
		
	}
	public void waitforelement(By findby) {
		WebDriverWait wai=new WebDriverWait(driver,Duration.ofSeconds(5));
		wai.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}

	public void waitforelementdisappear(By findby) {
		WebDriverWait wai=new WebDriverWait(driver,Duration.ofSeconds(5));
		wai.until(ExpectedConditions.invisibilityOfElementLocated(findby));
		
	}
	

}
 