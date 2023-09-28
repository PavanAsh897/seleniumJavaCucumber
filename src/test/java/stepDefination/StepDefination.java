package stepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utlitiles.Excel;
import Utlitiles.Parameters;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddCustomer;
import pageObject.DeleteTheProduct;
import pageObject.LoginPage;
import pageObject.ManufactureEdit;
import pageObject.SearchByEmail;

public class StepDefination extends base {
	
	
	String filepath = "C:\\Users\\pashadapu\\Downloads\\TestData.xlsx";
	@Before
	public void setUp() throws IOException {
	Properties configProp= new Properties();
	FileInputStream configProfile= new FileInputStream("config.properties");
	configProp.load(configProfile);	
	String br= configProp.getProperty("brower");
	if(br.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
		driver =new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(br.equals("Edge")) {
		System.setProperty("webdriver.edge.driver", configProp.getProperty("EdgePath"));
		driver =new EdgeDriver();
		driver.manage().window().maximize();
	}
	}
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
	   lp = new LoginPage(driver);
	}

	@When("user open URL {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	}

	@When("user enter username and password")
	public void user_enter_username_as_and_password() {
		
		
	 String Uname = Excel.getCellValue(filepath, "loginDetails", 1, 0);
	 String pwd = Excel.getCellValue(filepath, "loginDetails", 1,1 );
		
       lp.setUserName(Uname);
	   lp.setPassword(pwd);
	}

	@When("Click on login")
	public void click_on_login() {
	    lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccess."))
	    {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@SuppressWarnings("deprecation")
	@When("click on log out")
	public void click_on_log_out() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    lp.clickLogout();
	    Thread.sleep(3000);
	}  

	

	@Then("Close the Browser")
	public void close_the_browser() {
	    driver.quit();
	}
	
	// Customer creation....................................
	
	@Then("user can view dashborad")
	public void user_can_view_dashborad() {
		Addcust=new AddCustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", Addcust.getPageTitle());
	}

	@When("user click on Customer Menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
	    Addcust.clickOnCustomerMenu();
	}

	@When("click on Customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(3000);
	    Addcust.clickOnCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    Addcust.clickonAddnew();
	    Thread.sleep(3000);
	}

	@Then("user can see add new customer page")
	public void user_can_see_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", Addcust.getPageTitle());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException, ParseException {
		para= new Parameters();
		String EmployeeFristName=Excel.getCellValue(filepath, "EmployeeDetails", 1, 0);
		String EmployeeLastName=Excel.getCellValue(filepath, "EmployeeDetails", 1, 1);
		String  excelDateStr=Excel.getCellValue(filepath, "EmployeeDetails", 1, 2);
		String EmployeeCompany=Excel.getCellValue(filepath, "EmployeeDetails", 1, 7);
		String Contents=Excel.getCellValue(filepath, "EmployeeDetails", 1, 8);
		String EmployeeGender=Excel.getCellValue(filepath, "EmployeeDetails", 1, 5);
		String EmployeeVender=Excel.getCellValue(filepath, "EmployeeDetails", 1, 6);
		String EmployeeRole=Excel.getCellValue(filepath, "EmployeeDetails", 1, 3);
		String EmployeePassword=Excel.getCellValue(filepath, "EmployeeDetails", 1, 4);
		 
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = inputDateFormat.parse(excelDateStr);
        String formattedDate = outputDateFormat.format(date);
		
		
		
		Addcust.setEmail(para.EmployeeEmail);
		Addcust.setPassword(EmployeePassword);
		Addcust.setCustomerRole(EmployeeRole);
		Thread.sleep(3000);
		Addcust.setManagerOfVender(EmployeeVender);
		Addcust.setGender(EmployeeGender);
		Addcust.setFirstName(EmployeeFristName);
		Addcust.setLastname(EmployeeLastName);
		Addcust.setDob(formattedDate);
		Addcust.setCompanyName(EmployeeCompany);
		Addcust.setAdimContext(Contents);
		
		
	    
	}

	

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	   Addcust.clickOnSave();
	   Thread.sleep(3000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));

	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	
	// Search customer using Email
	@When("user enter Email")
	public void user_enter_email() {
		search = new SearchByEmail(driver);
	    search.setEmail("victoria_victoria@nopCommerce.com");
	}
	

	


	@When("click on search")
	public void click_on_search() throws InterruptedException {
		Thread.sleep(3000);
	    search.clickonSearchbtn();
	    Thread.sleep(3000);
	}
	@Then("user details should parsent in table")
	public void user_details_should_parsent_in_table() {
		boolean status=search.searchCustomerEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true,status);
	    
	}
	@Then("close the browser")
	public void close_the_browser11() {
	    driver.close();
	}
	
	
	// Deleting a product from catalog
	
	@When("user click on Catalog")
	public void user_click_on_catalog() {
		Dp= new DeleteTheProduct(driver);
		Dp.clickOnCatalog();
	  
	}

	@Then("User Click on product")
	public void user_click_on_product() {
	    Dp.clickOnProduct();
	}

	@Then("search for the product")
	public void search_for_the_product() throws InterruptedException {
		Dp.searchWithName("Nikon D5500 DSLR - Red");
		Dp.clickOnSearch();
		Thread.sleep(3000);
	    
	}

	@Then("Select the product and delete")
	public void select_the_product_and_delete() {
		Dp.serachForProductAndClickCheckbox("Nikon D5500 DSLR - Red");
		Dp.clickOnDeleteBtn();
		Dp.clickOnAlertYes();
	    
	}

	@Then("verify the product deleted or not")
	public void verify_the_product_deleted_or_not() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']")).getText().contains(Dp.TableContains()));
	    
	}

	@Then("Close the browser")
	public void close_the_browser1() {
		driver.quit();
	   
	}
	
	
	
	
	// Edit a manufactures and search for it
	
	@Then("User Click on Manuactures")
	public void user_click_on_manuactures() {
		Me=new ManufactureEdit(driver);
		Me.clickOnManufacture();
	}

	@Then("search for the Manuactures name")
	public void search_for_the_manuactures_name() {
		Me.serachByName("Apple");
		Me.clickOnSearchBtn();
		
	    
	}

	@Then("Select the Manuactures and edit")
	public void select_the_manuactures_and_edit() throws InterruptedException {
		Thread.sleep(3000);
		Me.serachForManufactureAndClickEdit("Apple");
		Me.changeName("Banana");
		Me.addDescribtion("New edit for Apple");
		Me.clickOnSave();
		
	   
	}

	@Then("verify the Edited Manuactures is in table")
	public void verify_the_edited_manuactures_is_in_table() {
		boolean status=Me.serachForManufactureAndRenameCheck("Banana");
		Assert.assertEquals(true,status );
		
	   
	}





}
