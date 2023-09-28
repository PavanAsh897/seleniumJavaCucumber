package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utlitiles.WaitHelper;

public class ManufactureEdit {
	public WebDriver ldriver;
	WaitHelper waithelper;
	public ManufactureEdit(WebDriver rdriver)
	{
		ldriver = rdriver;
		waithelper= new WaitHelper(ldriver);
	}
	By manufactureBtn=By.xpath("//a[contains(@href,'Manufacturer/List')]//p");
	By searchManufracture=By.xpath("//input[@id='SearchManufacturerName']");
	By serachBtn= By.xpath("//button[@id='search-manufacturers']");
	By totalCol= By.xpath("//div[@id='manufacturers-grid_wrapper']//tbody/tr/td");
	By totalRows=By.xpath("//div[@id='manufacturers-grid_wrapper']//tbody/tr");
	By inputName= By.id("Name");
	By saveBtn= By.xpath("//button[@name='save']");
	
	public void clickOnManufacture() {
		waithelper.waitElement(ldriver.findElement(manufactureBtn), 30);
		ldriver.findElement(manufactureBtn).click();
	}
	public void serachByName(String name) {
		waithelper.waitElement(ldriver.findElement(searchManufracture), 10);
		ldriver.findElement(searchManufracture).sendKeys(name);
	}
	
	@SuppressWarnings("deprecation")
	public void clickOnSearchBtn() {
		ldriver.findElement(serachBtn).click();
		ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public int getRows() {
		List<WebElement> rows= ldriver.findElements(totalRows);
		return rows.size();
		
	}
	
    @SuppressWarnings("deprecation")
	public void serachForManufactureAndClickEdit(String name ) {
    	ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		int rows=getRows();
		for(int i=1;i<=rows;i++) {
			String ManufactureName= ldriver.findElement(By.xpath("//div[@id='manufacturers-grid_wrapper']//tbody/tr["+i+"]/td[2]")).getText();
			if(ManufactureName.equals(name)) {
				
				
				ldriver.findElement(By.xpath("//a[contains(@href,'Edit/"+i+"')]")).click();
				ldriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
		}
	}
    
    public void changeName(String Newname) {
    	waithelper.waitElement(ldriver.findElement(inputName), 30);
    	ldriver.findElement(inputName).clear();
    	ldriver.findElement(inputName).sendKeys(Newname);
    }
    
    public void addDescribtion(String text) {
    	WebElement iframe=ldriver.findElement(By.id("Description_ifr"));
    	ldriver.switchTo().frame(iframe);
    	ldriver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
    	ldriver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys(text);
    	ldriver.switchTo().defaultContent();
    }
    
    public void clickOnSave() {
    	ldriver.findElement(saveBtn).click();
    }
    
 public boolean serachForManufactureAndRenameCheck(String rename ) {
		boolean flag=false;
		int rows=getRows();
		for(int i=1;i<=rows;i++) {
			String ReName= ldriver.findElement(By.xpath("//div[@id='manufacturers-grid_wrapper']//tbody/tr["+i+"]/td[2]")).getText();
			if(ReName.equals(rename)) {
				flag=true;
			}
		}
		return flag;
	}
			

}
