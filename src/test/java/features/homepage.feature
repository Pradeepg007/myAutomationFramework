Feature: Validating the features in homepage of makemytrip application

  Scenario: Validating if all the elements are present are not
    Given User lands on the makeMyTrip homepage
    When User see the signIn popup and closes that modal
    And user validates the top nav bar and verifies if all the elements are displayed
    And user validates the search bar and verifies if the elements are visible