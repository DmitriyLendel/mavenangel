package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.*;

public class PasswordPage extends Bindings {

	private WebDriver driver;

	public PasswordPage(WebDriver driver2) {
		this.driver = driver2;
	}
	

	public void setMasterPassword(String password) {
		WebElement element = driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input"));
		if (password == "") {
			element.clear();
		} else {
			element.sendKeys(password);
		}
	}

	public void setSiteName(String siteName) {
		WebElement element = driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input"));
		if (siteName == "") {
			element.clear();
		} else {
			element.sendKeys(siteName);
		}
	}

	public void clickGenerate() {
		//click("rre");
		
		click(By.xpath("html/body/form/table/tbody/tr[3]/td/input"),driver);
		try{
		Thread.sleep(2000);
		}catch(Exception ex){}
	}
	
	

	public void clearPassword() throws InterruptedException{
		driver.findElement(By.name("password")).clear();
		Thread.sleep(4000);
	}
	
	public String getPassword() {
		WebElement element = driver.findElement(By.name("password"));
		return element.getAttribute("value");
	}
	
	
	
	
	
}
