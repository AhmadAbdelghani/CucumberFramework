@Regression
Feature: Amazon login
  I want to be abble to login with valid credentials.
  I should not be logged in with invalid credentials.
  

  @amazonLogin @SmokeTests
  Scenario: User should be directed to login page 
  Given I am on amazon home page
  And The sign in button displays
  When I click on the sign in button 
  Then I should be directed to login page
  
  
  @amazonLogin @amazonInvalidUser
  Scenario: yoy sould not be directed to the password field when email is not valid
  Given I am on the loging page 
  When I enter invalid email "jon.dow@gmail"
  And I click the continue button 
  Then I should get error message says "We cannot find an account with that email address"
  And I should still in the login page
  
  
  
  
    
