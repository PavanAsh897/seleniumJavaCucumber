package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utlitiles.WaitHelper;

public class DeleteTheProduct {
	public WebDriver ldriver;
	WaitHelper waithelper;
	public DeleteTheProduct(WebDriver rdriver)
	{
		ldriver = rdriver;
		waithelper= new WaitHelper(ldriver);
	}
	By Catalog= By.xpath("//a[@href='#']//p[contains(text(),'Catalog')]");
	By product= By.xpath("//a[contains(@href,'Product/List')]");
	By searchProduct= By.xpath("//input[@id='SearchProductName']");
	By searchbtn=By.xpath("//button[@id='search-products']");
	By tableTotal= By.xpath("//div[@class='dataTables_scrollBody']");
	By totalRows= By.xpath("//div[@class='dataTables_scrollBody']//tbody/tr");
	By totalCol= By.xpath("//div[@class='dataTables_scrollBody']//tbody/tr/td");
	By productCheckbox= By.xpath("//input[@type='checkbox' and @class='checkboxGroups']");
	By alertYesBtn =By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");
	By Deletebtn=By.xpath("//button[@id='delete-selected']");
	
	public void clickOnCatalog() {
		
		waithelper.waitElement(ldriver.findElement(Catalog),30);
		ldriver.findElement(Catalog).click();
		
	}
	
	public void clickOnProduct() {
		waithelper.waitElement(ldriver.findElement(product),30);
		ldriver.findElement(product).click();
		
		
	}
	
	public void clickOnAlertYes() {
		waithelper.waitElement(ldriver.findElement(alertYesBtn),30);
		ldriver.findElement(alertYesBtn).click();
	}
	public void searchWithName(String name) {
		waithelper.waitElement(ldriver.findElement(searchProduct),30);
		ldriver.findElement(searchProduct).sendKeys(name);
		
	}
	@SuppressWarnings("deprecation")
	public void clickOnSearch() {
		
		ldriver.findElement(searchbtn).click();
		ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	public int getRows() {
		List<WebElement> rows= ldriver.findElements(totalRows);
		return rows.size();
		
	}
	public int getCol() {
		List<WebElement> col= ldriver.findElements(totalCol);
		return col.size();
		
	}
	
	public void serachForProductAndClickCheckbox(String name ) {
		
		int rows=getRows();
		for(int i=1;i<=rows;i++) {
			String ProductName= ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody/tr["+i+"]/td[3]")).getText();
			if(ProductName.equals(name)) {
				ldriver.findElement(productCheckbox).click();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void clickOnDeleteBtn() {
		waithelper.waitElement(ldriver.findElement(Deletebtn),30);
		ldriver.findElement(Deletebtn).click();
		ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	public String TableContains() {
		
		String nData= ldriver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody/tr[1]/td[1]")).getText();
		return nData;
	}
	

}
