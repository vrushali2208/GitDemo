Feature: Login into Application

Scenario: Positive test validating login
Given Initialise the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And click on login link of home to in order to land on sign in page
When User enters "vrusha.gavande@gmail.com" and "Vrushali123" and logs in
Then verify that user is successfully logged in

