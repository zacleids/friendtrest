Feature: Review
  As a user, I can get reviews of a movie, so that I can tell if I will want to see it.

  Scenario Outline: Reviews
    When I request the reviews of <movie>
    Then the number of reviews should be <num>

    Examples:
      | movie        | num |
      | deadpool     | 2   |
      | The Avengers | 1   |
      | The Maxtrix  | 0   |