Feature: Verify specific user is being returned using Rest-Assured
  Scenario Outline: Testing API returns correct response and specific user
    Given user do nothing
    When User calls the User API with "<userId>"
    Then User details are fetched "<firsName>""<LastName>""<EmailAddress>"
    Examples:
      | firsName  | LastName|EmailAddress          |userId  |
      |Janet      |Weaver   |janet.weaver@reqres.in|2       |
      |George     |Bluth    |george.bluth@reqres.in|1       |
      |Emma       |Wong     |emma.wong@reqres.in   |3       |