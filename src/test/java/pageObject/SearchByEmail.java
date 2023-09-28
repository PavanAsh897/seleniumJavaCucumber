package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utlitiles.WaitHelper;

public class SearchByEmail {
	public WebDriver ldriver;
	WaitHelper waithelper;
	public SearchByEmail(WebDriver rdriver)
	{
		ldriver = rdriver;
		waithelper= new WaitHelper(ldriver);
	}
	
	By searchEmail= By.xpath("//input[@id='SearchEmail']");
	By SearchFristName= By.xpath("//input[@id='SearchFirstName']");
	By searchLastName= By.xpath("//input[@id='SearchLastName']");
	By searchBymonth= By.cssSelector("[id=SearchMonthOfBirth]");
	By serachByDay= By.cssSelector("[id=SearchDayOfBirth]");
	By serachRgdFromDate= By.cssSelector("[id=SearchRegistrationDateFrom]");
	
	By serachRgdToDate= By.cssSelector("[id=SearchRegistrationDateTo]");
	By serachByComapany= By.cssSelector("[id=SearchCompany]");
	By Fulltable= By.xpath("//div[@id='customers-grid_wrapper']");
	By totalRows= By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr");
	By totalcoloumns= By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr/td");
	By serachbtn= By.xpath("//button[@id='search-customers']");
	
	
	
	public void setEmail(String email) {
		waithelper.waitElement(ldriver.findElement(searchEmail),30);
		ldriver.findElement(searchEmail).clear();
		ldriver.findElement(searchEmail).sendKeys(email);
		
	}
	
	public void setFname(String name) {
		waithelper.waitElement(ldriver.findElement(SearchFristName),30);
		ldriver.findElement(SearchFristName).clear();
		ldriver.findElement(SearchFristName).sendKeys(name);
		
	}
	public void setLname(String name) {
		waithelper.waitElement(ldriver.findElement(searchLastName),30);
		ldriver.findElement(searchLastName).clear();
		ldriver.findElement(searchLastName).sendKeys(name);
		
	}
	 
	public int getRows() {
	    List<WebElement> rows = ldriver.findElements(totalRows);
	    return rows.size();
	}

	public int getCols() {
	    List<WebElement> cols = ldriver.findElements(totalcoloumns);
	    return cols.size();
	}
	
	public void clickonSearchbtn() {
		
		ldriver.findElement(By.xpath("//span[@title='delete']")).click();
		ldriver.findElement(serachbtn).click();
		
	}
	 
	public boolean searchCustomerEmail(String email) {
		boolean flag=false;
		int rowCount=getRows();
		for(int i=1; i<=rowCount;i++) {
			String EmailId= ldriver.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+i+"]/td[2]")).getText();
			
			if(EmailId.equals(email)) {
				flag=true;
			}
		}
		return flag;
	}
}
		

