Feature: Checkout

  As a logged-in user
  I want to be able to checkout in my cart
  So that I can complete a purchase

  Scenario Outline: Successful checkout with valid credentials and order info
    Given I am on the login page for "<testType>" test
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see the "<expectedResult>"

    When I add product to cart
    Then I should see the shopping cart badge add up

    When I navigate to the cart page
    Then I should see the cart page

    When I see the number of products in the cart
    And I click the checkout button
    Then I should see the checkout your information page

    When I fill valid personal information
    And I click the continue button
    Then I should see the checkout overview page

    When I validate the checkout overview
    And I click the finish button
    Then I should see the confirmation message Thank you for your order!

    Examples:
      | testType | username      | password     | expectedResult |
      | positive | standard_user | secret_sauce | Products       |
