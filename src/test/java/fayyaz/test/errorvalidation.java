package fayyaz.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import fayyaz.pageobjects.ProductCatalogue;
import fayyaz.pageobjects.cart;
import fayyaz.testcomponenets.BaseTest;

public class errorvalidation extends BaseTest{
	
	@Test(groups= {"errorhandling"})	
	public void submitorder1() throws IOException {
		
		landingpage.loginapplication("fayyazhm1@gmail.com", "Fayyaz@123456");
		String cc=landingpage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", cc);
	}

	@Test
	public void producterrorvalidation() {
		String productname="ADIDAS ORIGINAL";
		ProductCatalogue pc=landingpage.loginapplication("fayyazhm1@gmail.com", "Fayyaz@123");
		List<WebElement> products=pc.getproductlist();
		pc.addproducttocart(productname);
		cart cartpage=pc.goToCart();
		Boolean match=cartpage.check("zara coat");
		Assert.assertFalse(match);
	}
	
}
