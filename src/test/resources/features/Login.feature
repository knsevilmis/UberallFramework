Feature: Login Functionality

  Scenario: User should be able to login with valid credentials
    Given user is on the login page
    When user enters "email@mail.com" on email box, "password" on password box
    And user clicks login button
    Then the page title should be "Dashboard"
  @wip
    Scenario Outline: User should not be able to login with invalid credentials
      Given user is on the login page
      When user enters "<email>" on email box, "<password>" on password box
      And user clicks login button
      Then user should see "Please check your Email and Password." as warning message
      Examples:
        | email        | password |
        |asdfgh@as.com | 1234566  |
        |asdfgh@as.com | 577577588  |
        |asfdsf@as.com | dgdfıkljljl|


