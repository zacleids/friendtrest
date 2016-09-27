Feature: createAccount
  As a user, I can get create an account, so that I can use the system.

  Scenario Outline: createAccount
    When I request to create an account with <username>
    Then I will recieve the message Hello <user>. Account created successfully!

    Examples:
      | username    | user        |
      | NewUser1    | NewUser1    |
      | AwesomeUser | AwesomeUser |
      | NPH4242     | NPH4242     |