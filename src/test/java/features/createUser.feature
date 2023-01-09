@Users
Feature: Verify an user is created
  Scenario: Testing API returns correct response and creates user
    Given user do nothing
    When User calls the create user API
    Then User is created