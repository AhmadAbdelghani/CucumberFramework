@Regression
Feature: Amazon search
      As a user i should be anle to search an item 
      and th search should releven to search cririria

  @amazonSearch @SmokeTests
  Scenario Outline: user is able to to search multiple data set
    Given I am on amazon home page
    When I search item "<items>"
    And I click search button
    Then search item "<items>" should be displayed in the search bar

    Examples: items
      | items             |
      | coffee mug        |
      | pretty coffee mug |
      | cute coffee mug   |
      | ugly coffee mug   |
      | colone            |
