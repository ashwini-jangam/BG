@Smoke
Feature: this feature test the add  bank functionality
Background: 
Given 'chrome' browser is Opened and application Url is Launched
And Application is login
 

Scenario: verify add bank for valid data
Given click on bnak Menu
And click on add bank button
Then Fill all Mantetory Fields
And Click on submit button
And Assert Result