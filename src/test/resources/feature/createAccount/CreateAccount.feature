Feature: createAccount
  As a user, I can get create an account, so that I can use the system.

  Scenario Outline: createAccount
    When I request to create an account with <username> and <password>
    Then, I will recieve the message "Hello <user>. Account created successfully!"

    Examples:
      | username    | password | user        |
      | NewUser1    | hello12  | NewUser1    |
      | AwesomeUser | 123      | AwesomeUser |
      | NPH4242     | celeb    | NPH4242     |