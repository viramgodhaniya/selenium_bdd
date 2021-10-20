Feature: feature to test google search functionality

  Scenario: Validate google search is working
    Given browser window is open
    And user is on google "https://google.com" search page
    When user enters "automation step by step" text in search box
    And hits enter
    Then user is navigated to search results
