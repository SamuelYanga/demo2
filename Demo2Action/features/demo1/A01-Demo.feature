@all1
Feature: A01-Demo

Background:
	Given Open the home page.

@demoa01
Scenario Outline: search product, and confirm the product title.
    And Close the register banner.
    And Search one product. "<product>"
    Then The product is display on search page. "<product>", "<productName>"
    Examples:
    |product	|productName	|
    |361		|完美遮瑕霜淺杏	|
