Feature: Validating the features in homepage of makeMyTrip application

  Scenario: Validating if all the elements are present are not
    Given User lands on the MakeMyTrip homepage
    When User closes the sign in pop-up once it's shown on the page
    And user validates the top nav bar and verifies if all the elements are displayed
    And user validates the search bar and verifies if the elements are visible