Feature: Sign In to User's account
    As a: User
    I want: to sign in to my account
    So that: I can use the page as a logged user

#    UNHAPPY PATH
    Scenario: Try to sign in with empty form
        Given The user opens home page
        When User clicks on the my account button
        And User select My Account from drop down list
        Then User is redirected to the sign in form
        When User try to sign in by empty form
        Then The error message is visible about empty fields