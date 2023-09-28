Feature: Login


Scenario: Sucessfull Login With valid credentials

Given user launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/admin/"
And user enter username and password
And Click on login
Then page title should be "Dashboard / nopCommerce administration"
And click on log out
And Close the Browser 