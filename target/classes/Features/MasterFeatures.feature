@Smoke
Feature: this feature test the main module functinality

Background: 
Given 'chrome' browser is Opened and application Url is Launched
And Application is login

Scenario: verify master menu shows submenu list
Given Hover on Master Menu
Then Verify Submenu List