Feature: Changes in  products page

  
  Scenario: Delete a specfic product
   Given user launch chrome browser
   When user open URL "https://admin-demo.nopcommerce.com/admin/"
   And user enter username and password
   And Click on login
   Then user can view dashborad
   When user click on Catalog
   Then User Click on product
   Then search for the product
   And Select the product and delete
   And verify the product deleted or not
   And Close the browser
 