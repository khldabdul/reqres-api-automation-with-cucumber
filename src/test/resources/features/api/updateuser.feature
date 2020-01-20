@Api @User @Regression
Feature: Update User

  @UpdateUser
    Scenario: Update user success
    Given set name to 'khalid'
    Given set job to 'tester'
    When send update user api
    Then update user api response equals with name request