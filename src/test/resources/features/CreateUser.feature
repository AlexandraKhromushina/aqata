# Created by alexandrakhromushina at 31.08.2022
Feature: Create a new user
  I am adding a new user

  Scenario: Successfully add a new male inactive user
    # If some fields were optional, I would introduce more positive cases:
    # one where we only send the required fields and one where we send them all
    Given I set POST new user
    And I fill in "name" with "Owen Milgrim"
    And I fill in "email" with "taketheApill@mail.ru"
    And I fill in "gender" with "male"
    And I fill in "status" with "inactive"
    When I create a new user
    Then Status code equals 201
    And Response contains new user data

  Scenario: Successfully add a new female active user
    Given I set POST new user
    And I fill in "name" with "Annie Landsberg"
    And I fill in "email" with "taketheBpill@mail.ru"
    And I fill in "gender" with "female"
    And I fill in "status" with "active"
    When I create a new user
    Then Status code equals 201
    And Response contains new user data

  Scenario: Negative: name has the wrong format
    Given I set POST new user
    And I fill in "name" with 123
    And I fill in "email" with "taketheBpill@mail.ru"
    And I fill in "gender" with "female"
    And I fill in "status" with "active"
    When I create a new user
    Then Status code equals 422
    And Response contains error message

  # Add negative scenarios with wrong formats for the rest of the fields
  # Add negative scenario with a corrupted JSON
  # Add negative scenario with a taken name/email
  # Add negative scenario with an extra field
  # Add negative scenario with gender and status being strings but not the expected ones
  # Add negative scenario with a wrong auth token
  # Add negative scenario with a wrong content-type header
  # Add negative scenario with an offline/unreachable endpoint