@Api @Resource @Regression
Feature: Get Resource

  @GetSingleResource
  Scenario: Get single resource success
    Given test api set id to '1'
    When  send get single resource
    Then  get single resource api response equals with request