@all
Feature: AmwayGCR_HK_AGHP_27_TC

Background:
	Given Open the home page.

@AGHP-27_AHK_01
Scenario Outline: Verify the state of the 'Add to Cart' button for selected variant which is in stock
    And Close the register banner.
    And Search one product. "<product>"
    And Navigate to a PDP page as a guest user. "<product>"
    Then Verify that the following details of a product are displayed to the Guest user on the PDP. "<name>" "<price>"
    Examples:
    |product	|name			|price		|
    |1244		|蜂蜜卵磷脂粉		|HKD743.00	|
