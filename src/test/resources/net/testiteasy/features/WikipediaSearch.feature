@regression
@smoke
@search
Feature: Wikipedia search functionality

  As a user I want to be able to search for articles.

  Scenario: Type search query in search field
    Given user open application
    When welcome screen ready
    When user tap on the search field
    When user type in search line "Appium"
    Then search results contain "Appium"
