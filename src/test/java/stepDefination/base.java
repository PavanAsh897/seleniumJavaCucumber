package stepDefination;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Utlitiles.Parameters;
import pageObject.AddCustomer;
import pageObject.DeleteTheProduct;
import pageObject.LoginPage;
import pageObject.ManufactureEdit;
import pageObject.SearchByEmail;

public class base {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomer Addcust;
	public Parameters para;
	public SearchByEmail search;
	public DeleteTheProduct Dp;
	public ManufactureEdit Me;

	
	
	
	
	public static String randomString() {
		String generatString = RandomStringUtils.randomAlphabetic(5);
		return generatString;
	}
	
}
