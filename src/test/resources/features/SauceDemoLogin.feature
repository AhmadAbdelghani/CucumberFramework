@Regression
Feature: Sauce demo Login
       This feature focuses on positive and nigative login tests

  Background: 
    Given I am on the sauceDemo login page

  @SauceValidLogin @SmokeTests
  Scenario: Valid Login Test
    When I enter valid user name "standard_user" and valid password "secret_sauce"
    And I click on login button
    Then i should be directed to inventory page
    And There should be 6 items in the page

  @SauseInvalidLogin
  Scenario: Invalid login test
    When I enter invalid user name "standard_user" and valid password "secret_invalidsauce"
    And I click on login button
    Then I should not be logged in
    And Error message should display "Epic sadface: Username and password do not match any user in this service"
   
   
   @SuaceInvalidTests
  Scenario Outline: User is not able to login with invalid credentials
    When I enter invalid user name "<username>" and valid password "<password>"
    And I click on login button
    Then I should not be logged in
    And Error message should display "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | username      | password       |
      | standard_user | secret_invalid |
      | standard      | secret         |
      | standard      | secret1233     |
