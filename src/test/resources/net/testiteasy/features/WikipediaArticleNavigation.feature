@regression
@navigation
Feature: Wikipedia article navigation

  As a user I want to be able to open an article from search results.

  Scenario: Open article from search results
    Given user open application
    When welcome screen ready
    When user tap on the search field
    When user type in search line "Appium"
    When user select first search result "Appium"
    Then article "Appium" is opened