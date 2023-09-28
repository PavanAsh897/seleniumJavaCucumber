package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
	public WebDriver ldriver;
	By textEmail= By.id("Email");
	By textPassword= By.id("Password");
	By btnLogin = By.cssSelector(".login-button");
	By Logout = By.cssSelector("#navbarText > ul > li:nth-child(3) > a");
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
	}
	
	
	
	public void setUserName(String uname)
	{
		ldriver.findElement(textEmail).clear();
		ldriver.findElement(textEmail).sendKeys(uname);
	}
	
	public void setPassword(String pwd )
	{
		ldriver.findElement(textPassword).clear();
		ldriver.findElement(textPassword).sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		ldriver.findElement(btnLogin).click();
	}
	
	public void clickLogout()
	{
		ldriver.findElement(Logout).click();
	}
	
	


	

	
	
	

}