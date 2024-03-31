package fayyaz.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fayyaz.pageobjects.ProductCatalogue;
import fayyaz.pageobjects.cart;
import fayyaz.pageobjects.confirmation;
import fayyaz.pageobjects.order;
import fayyaz.pageobjects.payment;
import fayyaz.testcomponenets.BaseTest;

public class Standalone2 extends BaseTest{
	String productname;
	String country="ind";
	
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitorder(HashMap<String,String> map) throws IOException {
		this.productname=map.get("productname");
		System.out.print(map.get("username"));
		ProductCatalogue pc=landingpage.loginapplication(map.get("username"), map.get("password"));
		pc.addproducttocart(productname);
		cart cartitem=pc.goToCart();

		Boolean match=cartitem.check(productname);
		Assert.assertTrue(match);
		payment pay=cartitem.checkOut();
		
		pay.selectCountry(country);
		confirmation conf=pay.gotoconfirmation();


		String mat=conf.messagecheck();
		Assert.assertTrue(mat.equalsIgnoreCase("Thankyou for the order."));
	}
	
	@Test(dependsOnMethods= {"submitorder"})
	public void orderHistoryTest() {
		ProductCatalogue pc=landingpage.loginapplication("fayyazhm1@gmail.com", "Fayyaz@123");
		order orderpage=pc.goToOrderPage();
		Assert.assertTrue(orderpage.verifyProductDisplay("ADIDAS ORIGINAL"));
	}
	
	@DataProvider	
	public Object[] getData() throws IOException {
//		HashMap<String,String> map1=new HashMap();
//		map1.put("username", "fayyazhm1@gmail.com");
//		map1.put("password", "Fayyaz@123");
//		map1.put("productname", "ADIDAS ORIGINAL");
//		HashMap<String,String> map2=new HashMap();
//		map2.put("username", "fayyazhm2@gmail.com");
//		map2.put("password", "Fayyaz@123");
//		map2.put("productname", "ZARA COAT 3");
		
		List<HashMap<String,String>> hash=getJsonToHashMap(System.getProperty("user.dir")+"\\src\\test\\java\\fayyaz\\data\\purchaseorder.json");
			
		return new Object[][] {{hash.get(0)},{hash.get(1)}};
//		return new Object[] {map1,map2};
}
}