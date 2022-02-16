Feature: As a user I am able to perform Trade app add trade functions
  I want to add, delete, update trades

  @AddTrade  @SmokeTest
  Scenario: As a user i want to add a trade
    Given I am on the Trade app login page
    When I enter username "Ahmad" and password "SuperAhmad123!"
    And I click on sign in button
    Then I should be Trade Home Page
    When I click on add trade button
    Then I should be on add trade page
    When I select "Buy to Open" and I enter symbol "sportlex" entrydate "01/01/2021" entryprice "50" exitdate "01/10/2021" exitprice "60"
    And I click save button
    Then THE Trade is displayed on the Trade table
