@Api @User @Regression
Feature: Get List User

  @GetListUser
  Scenario: Get list user success
    Given set page to '2'
    Given set per_page to '3'
    When  send get all user api
    Then  get list user api response equals with request