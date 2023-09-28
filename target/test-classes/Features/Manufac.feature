Feature: Changes in  Manuactures page

  
  Scenario: Edit a specfic Manuactures name
   Given user launch chrome browser
   When user open URL "https://admin-demo.nopcommerce.com/admin/"
   And user enter username and password
   And Click on login
   Then user can view dashborad
   When user click on Catalog
   Then User Click on Manuactures
   Then search for the Manuactures name
   And Select the Manuactures and edit
   And verify the Edited Manuactures is in table
   And Close the browser