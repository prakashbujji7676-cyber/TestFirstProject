@featurefile
Feature: Validate Registration and Stamp Revenue login file


Scenario: Successful Registration and Stamp Revenue login
  Given user is on Registration login page
  When user enters valid credentials 
  And clicks on the Login button
  And clicks on the Office Loggin button
 