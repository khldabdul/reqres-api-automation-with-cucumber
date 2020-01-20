@Api @User @Regression
Feature: Delete User

  @DeleteUser
    Scenario: Delete user success
    Given test api set id to '1'
    When  send delete user api