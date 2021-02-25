Feature: This feature Test the login page  for valid and invalid Input

  Background: 
    Given 'chrome' browser is Opened
    And application Url is Launched

 Scenario Outline: verify Login page for multiple Input 
  Given I have '<username>' as mobile no
  And '<password>' as password
  When I hit on login button
  Then verify Login pass or Fail  Message

  Examples: 
   | username   | password |
   | 9876543561 | admin    |
   | 7654356145 | admin    |
   | 1234567890 | admin  |
   | 9876543210 | admin    |
   
   
    @Ashwini
  Scenario Outline: Verify mobilenumber and Password for multiple inputs
    Given I have '<username>' as mobile no
  And '<password>' as password
  When I hit on login button
  Then verify error msg for mobile number

    Examples: 
      | username   | password |
      |   98564562 | admin    |
      | 98765432102 | admin   |
      |  |admin|
      |1233|admin|
      |1234567890|admi|
      |9823564578|   |
   
   