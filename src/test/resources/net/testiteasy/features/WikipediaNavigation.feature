@regression
@smoke
Feature: Navigation test

  Scenario: Search and navigate back
    Given user open application
    When welcome screen ready
    When user tap on the search field
    When user type in search line "Android"
    When user press back
    Then search results contain "Android"
