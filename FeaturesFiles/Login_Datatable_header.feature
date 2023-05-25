Feature: Login cardholder portal
Scenario: The login scenario with data table
Given User login the page
When User can enter valid username and password
|Username        |Password     |
|5192607817637308|GFHJ76878GVHJ|
And click the logon button
Then the user will view to home page