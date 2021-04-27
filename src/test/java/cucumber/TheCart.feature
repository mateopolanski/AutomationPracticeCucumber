Feature: Cart status
    As a: User
    I want: to check the status of my cart
    So that: I can confirm if cart is empty or loaded

    Scenario: Validate go to the empty cart from main page
        Given The user opens home page
        When The user clicks on the cart button on main page
        Then Page with text about cart status is displayed


    Scenario Outline: Validate cart status when product added to cart
        Given The user opens home page
        When The user searches for '<ProductName>'
        Then The user is redirected to results page
        When User adds first item to the cart
        Then Cart icon status on the nav bar is changed

        Examples:
            | ProductName |
            | wallet  |