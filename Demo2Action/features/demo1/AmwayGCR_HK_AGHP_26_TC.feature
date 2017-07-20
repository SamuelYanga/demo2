@all
Feature: AmwayGCR_HK_AGHP_26_TC

@AGHP-27_AHK_02
Scenario Outline: Verify that the following details of a product are displayed to the Guest user on the PDP.
    Given Navigate to the HK website by entering the URL or an embedded link from an external Amway site
    And Click on any 2nd level Product Category. "<level1stMenuName>" "<level2stMenuName>"
    Then Check and verify the available bands for the Price filter. "<priceFilter>"
    Examples:
    |level1stMenuName	|level2stMenuName	|priceFilter	|
    |紐崔萊				|維他命和礦物質		|300-500		|
