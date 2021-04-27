Feature: Save the product
    As an: User
    I want: to add product to my favourite list
    So that: I can save it for the future

    Scenario Outline: Validate save searched product
        Given The user opens home page
        When The user searches for '<ProductName>'
        And The user go to the first product page
        Then The user save the product
        When The user go to saved products
        Then The user is redirected to page with saved products

        Examples:

            | ProductName |
            | wallet       |

    Scenario Outline: Validate delete product from saved
        Given The user opens home page
        When The user searches for '<ProductName>'
        And The user go to the first product from watches result page
        Then The user save the product
        When The user go to saved products
        Then The user is redirected to page with saved products
        When The user delete the products from saved
        Then There the saved section is empty

        Examples:

            | ProductName |
            | jacket     |