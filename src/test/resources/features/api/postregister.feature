@Api @User @Regression
Feature: Register User

  @UpdateUser
  Scenario: Register user success
    Given set email to 'michael.lawson@reqres.in'
    Given set password to '123456'
    When send post register user api
    Then post register user response equals with request

  @UpdateUser
  Scenario Outline: Get failed because '<reason>'
    Given set email to '<email>'
    Given set password to '<password>'
    When  send post register user api

    Examples:
      | email                           | password    | reason                    |
      | null                            | null        | missing email & password  |
      | null                            | 123456      | email is null             |
      | michael.lawson@reqres.in        | null        | password is null          |