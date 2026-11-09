@regression
@navigation
Feature: Search navigation

  Scenario: Return to search results from opened article
    Given user open application
    When welcome screen ready
    When user tap on the search field
    When user type in search line "Appium"
    And user select first search result "Appium"
    And user go back
    Then search results contain "Appium"