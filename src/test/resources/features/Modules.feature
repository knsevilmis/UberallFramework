Feature: Check Modules Functionality

  Scenario Outline: User should navigate the main page modules
    Given user is on the main page
    When user clicks "<module1>" "<module2>" module
    Then user should see "<module2>" page
    Examples:
      | module1 | module2|
      |CoreX|Mission Control|
      |Solutions|Retail|
      |CoreX |Listings|
      |CoreX|Reviews|
      |Company  |About Us|
