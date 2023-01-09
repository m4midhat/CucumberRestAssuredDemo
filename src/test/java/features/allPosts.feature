@Posts
Feature: Verify all posts are being returned using Rest-Assured
  Scenario: Testing API returns correct response and posts list
    Given user do nothing
    When User calls the posts API
    Then response code is 200
    And All posts are returned
