@tag
Feature: Error Validation
  I want to use this template for my feature file eror validation

  @tag2
  Scenario Outline: Error validation of login page
    Given I Landed on Ecommerce Webpage
    Given Logged in with user <username> and <password>
    Then I verify the "Incorrect email or password." message in landing page

Examples: 
      | username            | password    | productname      |country|
      | fayyazhm1@gmail.com |Fayyaz@12   | ADIDAS ORIGINAL  |ind    |