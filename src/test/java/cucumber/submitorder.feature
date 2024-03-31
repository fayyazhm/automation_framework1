@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file

	Background:
	Given I Landed on Ecommerce Webpage
	
  @tag2
  Scenario Outline: positive test for submitting your order
    Given Logged in with user <username> and <password>
    When I add product <productname> to cart
    And Checkout the <productname> and submit and select <country>
    Then I verify the "THANKYOU FOR THE ORDER." message in confirmation page
    Examples: 
      | username            | password    | productname      |country|
      | fayyazhm1@gmail.com |Fayyaz@123   | ADIDAS ORIGINAL  |ind    |
      
