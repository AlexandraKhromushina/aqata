# Created by alexandrakhromushina at 31.08.2022
Feature: Create a new user
  I am adding a new user

  Scenario: Successfully add a new user
    # If some fields were optional, I would introduce 2 different positive cases:
    # one where we only send the required fields and one where we send them all
    Given I set POST new user
    When I fill in "name" with "Owen Milgrim"
    And I fill in "email" with "taketheApill@mail.ru"
    And I fill in "gender" with "male"
    And I fill in "status" with "inactive"
    Then I am on the "My profile" page on URL "www.mycompany.com/myprofile"
    And I should see "Welcome to your profile" message
    And I should see the "Log out" button