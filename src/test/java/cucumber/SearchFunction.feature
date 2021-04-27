Feature: Search for product
    As an: User
    I want: to search specific product
    So that: I can select from results

    Scenario Outline: Validate searching the product
        Given The user opens home page
        When The user searches for '<ProductName>'
        Then The user is redirected to page with results for search

        Examples:
            | ProductName |
            | hat      |

#    UNHAPPY PATH
    Scenario Outline: Validate searching special sign
        Given The user opens home page
        When The user searches for '<AccidentallyTypedSpecialCharacter>'
        Then Search form can handle special character and no results message is visible

        Examples:
            | AccidentallyTypedSpecialCharacter |
            | =                                 |

    Scenario: Validate searching the product using category pages
        Given The user opens home page
        When The user navigate to Marketplace
        And The user select the category and subcategory
        Then The user is redirected to page with results for Marketplace