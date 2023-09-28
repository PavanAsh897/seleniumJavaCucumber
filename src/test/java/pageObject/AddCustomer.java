package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */
public class AddCustomer {
	public WebDriver ldriver;
	public AddCustomer(WebDriver rdriver)
	{
		ldriver = rdriver;
		
	}
	By link_customer_menu = By.xpath("(//a[@href='#' ] )[7]");
	By link_costumer_menu_item= By.xpath("(//a[contains(@href,'Customer/List')])[1]");
	By Add_new_btn = By.xpath("//a[@class='btn btn-primary']");
	By txtEmail= By.id("Email");
	By txtPassword = By.id("Password");
	By txtFirstName = By.id("FirstName");
	By txtLastName= By.id("LastName");
	By mGender = By.id("Gender_Male");
	By fGender = By.id("Gender_Female");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By drpVender= By.id("VendorId");
	By txtCompanyName= By.id("Company");
	By customerRole = By.xpath("(//div[@role=\"listbox\"])[2]");
	By listAdmistrator= By.xpath("//li[contains(text(),'Administrators')]");
	By listGuests=By.xpath("//li[contains(text(),'Guests')]");
	By ListRegistered= By.xpath("//li[contains(text(),'Registered')]");
	By adminComment= By.id("AdminComment");
	By btnSave= By.xpath("//button[@type='submit' and @name='save']");
	
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu()
	{
		ldriver.findElement(link_customer_menu).click();
		
		
		
	}
	public void clickOnCustomerMenuItem()
	{
		ldriver.findElement(link_costumer_menu_item).click();
	}
	
	public void clickonAddnew()
	{
		ldriver.findElement(Add_new_btn).click();
	}
	
	public void setEmail(String Email)
	{
		ldriver.findElement(txtEmail).sendKeys(Email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setCustomerRole(String role)
	{
		if(!role.equals("Vendors")) {
			ldriver.findElement(By.xpath("//span[@title='delete']")).click();
		}
		ldriver.findElement(customerRole).click();
		WebElement listitem;
 ;
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(listAdmistrator);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(listGuests);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(ListRegistered);
		}
		else
		{
			listitem=ldriver.findElement(listAdmistrator);
		}
//		listitem.click();
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", listitem);
		
	}
	
	public void setManagerOfVender(String value)
	{
		Select drp = new Select(ldriver.findElement(drpVender));
		drp.selectByVisibleText(value);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(mGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(fGender).click();
		}
		else
		{
			ldriver.findElement(mGender).click();
		}
	}
	public void setFirstName(String Fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(Fname);
	}
	public void setLastname(String Lname)
	{
		ldriver.findElement(txtLastName).sendKeys(Lname);
	}
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String cname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(cname);
	}
	public void setAdimContext(String content)
	{
		ldriver.findElement(adminComment).sendKeys(content);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
}
