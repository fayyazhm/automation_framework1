package fayyaz.test;

import org.openqa.selenium.chrome.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.*;

public class Standalone {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("fayyazhm1@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Fayyaz@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wai=new WebDriverWait(driver,Duration.ofSeconds(5));
		wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
		List<WebElement> lis=driver.findElements(By.cssSelector("div.mb-3"));
		WebElement d=lis.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		d.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		String succ=wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))).getText();
		System.out.println(succ);
		wai.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> dd=driver.findElements(By.cssSelector(".cartSection h3"));
		dd.stream().filter(product->product.getText().contains("ADIDAS ORIGINAL")).forEach(product->System.out.println(product.getText()));
		Boolean match=dd.stream().anyMatch(product->product.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "ind").build().perform();
		wai.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> ld=driver.findElements(By.cssSelector(".ta-item"));
		System.out.println(ld);
		for(WebElement cv:ld) {
			System.out.println(cv);
			String cit=cv.findElement(By.cssSelector("span[class='ng-star-inserted']")).getText();
			if (cit.equalsIgnoreCase("india")) {
				cv.findElement(By.cssSelector("span[class='ng-star-inserted']")).click();
				break;
			}
		}	
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		String conf=driver.findElement(By.cssSelector(".hero-primary")).getText().trim();
		Assert.assertTrue(conf.equalsIgnoreCase("Thankyou for the order."));
//		for(int i=0;i<=lis.size();i++) {
//			System.out.println(lis.get(i).findElement(By.tagName("h5")).getText());
//			if(lis.get(i).findElement(By.tagName("h5")).getText().equals("ADIDAS ORIGINAL")) {
//				lis.get(i).findElement(By.xpath(".//i[@class='fa fa-shopping-cart']")).click();
//			}
//		}
		
		
	}

}
