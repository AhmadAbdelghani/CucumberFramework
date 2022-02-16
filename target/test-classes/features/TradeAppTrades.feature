Feature: As a user I am able to perform Trade app add trade functions
  I want to add, delete, update trades

  @AddTrade @SmokeTests  @TradeJournal
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
    And The trade data is deleted on the Database

  @AddTradeWithTableData  @SmokeTests  @TradeJournal
  Scenario: As a user i want to add a trade
    Given I am on the Trade app login page
    When I enter username "Ahmad" and password "SuperAhmad123!"
    And I click on sign in button
    Then I should be Trade Home Page
    When I click on add trade button
    Then I should be on add trade page
    When I enter the fowllwing Data
      | Buy to Open | JAVA16 | 01/01/2021 | 50 | 01/10/2021 | 60 |
    And I click save button
    Then THE Trade is displayed on the Trade table
    And The trade data is deleted on the Database
    
    
    
    
    @AddTradeAndValidate  @SmokeTests @TradeJournal
  Scenario: As a user i want to add a trade
    Given I am on the Trade app login page
    When I enter username "Ahmad" and password "SuperAhmad123!"
    And I click on sign in button
    Then I should be Trade Home Page
    When I click on add trade button
    Then I should be on add trade page
    When I enter the fowllwing Data
      | Buy to Open | JAVA16 | 01/01/2021 | 50.0 | 01/10/2021 | 60.0 |
    And I click save button
    Then THE Trade is displayed on the Trade table
    And the trade data resides in database correctly
    And The trade data is deleted on the Database
    
    @InsertDB  @TradeJournal @TradeJournal @SmokeTests
    Scenario: As a user, I am able to insert a trade to Database
    Given I executed Insert query with the following data to Database
    |'23'|'1'|'0'|'Jmeter'|'2021-10-10'|'100.0'|'2024-12-30'|90.0|'0'|
    Given I am on the Trade app login page
    When I enter username "Ahmad" and password "SuperAhmad123!"
    And I click on sign in button
    Then I should be Trade Home Page
    When I search the "Jmeter" on 
    And I click  search button 
    Then THE Trade input is displayed on the Trade table
     And The trade data is deleted on the Database
    
    
    
