Feature: Customer


Scenario: Add new Customer

Given user launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/admin/"
And user enter username and password
And Click on login
Then user can view dashborad
When user click on Customer Menu
And click on Customer menu item
And click on Add new button
Then user can see add new customer page
When user enter customer info
And click on save button
Then user can view confirmation message "The new customer has been added successfully"
And close browser


Scenario: Search the customer by email

Given user launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/admin/"
And user enter username and password
And Click on login
Then user can view dashborad
When user click on Customer Menu
And click on Customer menu item
And user enter Email
And click on search
Then user details should parsent in table
And close the browser