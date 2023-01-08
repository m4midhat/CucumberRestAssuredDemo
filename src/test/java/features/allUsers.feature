Feature: Verify all users are being returned using Rest-Assured
Scenario: Testing API returns correct response and users list
    Given user do nothing
    When User calls the User API
    Then response code is 200
    And All users are returned
