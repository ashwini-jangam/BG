Feature: This feature Test the login page  for valid and invalid Input

  Background: 
    Given 'chrome' browser is Opened
    And application Url is Launched

  @Regression
  Scenario Outline: verify Login page for multiple Input
    Given I have '<username>' as mobile no
    And '<password>' as password
    When I hit on login button
    Then verify Login pass or Fail  Message

    Examples: 
      | username   | password   |
      | 9876543561 | admin      |
      | 7654356145 | admin      |
      | 1234567890 | admin      |
      | 9876543210 | admin      |
      | 9876543210 | admin12345 |
      | 9876543210 | ad  min    |

  @Regression
  Scenario Outline: Verify  multiple inputs for mobilenumber fields
    Given I have '<username>' as mobile no
    And '<password>' as password
    When I hit on login button
    Then verify error msg for mobile number

    Examples: 
      | username    | password |
      |    98564562 | admin    |
      | 98765432102 | admin    |
      |             | admin    |
      |        1233 | admin    |

  @Regression
  Scenario Outline: Verify  multiple inputs for Password Field fields
    Given I have '<username>' as mobile no
    And '<password>' as password
    When I hit on login button
    Then verify error msg for Password

    Examples: 
      | username   | password |
      | 9856456200 | admi     |
      | 7845126532 |          |

  @Regression
  Scenario Outline: Verify blank   Mobile number and password feilds
    Given I have '<username>' as mobile no
    And '<password>' as password
    When I hit on login button
    Then verify error msg blank input

    Examples: 
      | username | password |
      |          |          |
