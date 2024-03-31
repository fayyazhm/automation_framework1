package fayyaz.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.testng.Assert;

import fayyaz.pageobjects.LandingPage;
import fayyaz.pageobjects.ProductCatalogue;
import fayyaz.pageobjects.cart;
import fayyaz.pageobjects.confirmation;
import fayyaz.pageobjects.payment;
import fayyaz.testcomponenets.BaseTest;

public class stepdefinitionimp extends BaseTest {
	public LandingPage landingpage;
	public ProductCatalogue pc;
	public payment pay;
	public confirmation conf;
	 
	@Given("I Landed on Ecommerce Webpage")
	public void I_Landed_on_Ecommerce_Webpage () throws IOException {
		System.out.println("landingpage");
		landingpage= launchApplication();
	}

	@Given("^Logged in with user (.+) and (.+)$")
	public  void logged_in_with_user_and_pass(String username,String password) throws IOException {
		System.out.println(username + password);
		pc=landingpage.loginapplication(username, password);
		}	
	
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productname) throws IOException{
		System.out.println("addproduct");
		pc.addproducttocart(productname);
	}
	

	@When("^Checkout the (.+) and submit and select (.+)$")
	public void Checkout_the_product_and_submit(String productname,String country) throws IOException {
		System.out.println("checkout");
		cart cartitem=pc.goToCart();
		Boolean match=cartitem.check(productname);
		Assert.assertTrue(match);
		payment pay=cartitem.checkOut();
		pay.selectCountry(country);
		conf=pay.gotoconfirmation();
	}
	
	@Then("I verify the {string} message in confirmation page")
	public void I_verify_message_in_confirmation_page(String message) throws IOException {
		String mat=conf.messagecheck();
		Assert.assertTrue(mat.equalsIgnoreCase(message));
		driver.close();
	}
	
	@Then("I verify the {string} message in landing page")
	public void I_verify_message_in_landing_page(String message) throws IOException {
		String cc=landingpage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", message);
		driver.close();
	}
}
		