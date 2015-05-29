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
		WebElement element = driver.findElement(By.cssSelector("form.callout input[name=master]"));
		if (password == "") {
			element.clear();
		} else {
			element.clear();
			element.sendKeys(password);
		}
	}

	public void setSiteName(String siteName) {
		WebElement element = driver.findElement(By.cssSelector("form.callout input[name=site]"));
		if (siteName == "") {
			element.clear();
		} else {
			element.clear();
			element.sendKeys(siteName);
		}
	}

	public void clickGenerate() {
		//click("rre");
		
		click(By.cssSelector("form.callout input[type=submit]"),driver);
		try{
		Thread.sleep(2000);
		}catch(Exception ex){}
	}
	
	

	public void clearPassword() throws InterruptedException{
		driver.findElement(By.cssSelector(".output input[name=password]")).clear();
		Thread.sleep(4000);
	}
	
	
	public void RefreshPage(){
		driver.navigate().refresh();
	}
	
	public String getPassword() {
		WebElement element = driver.findElement(By.cssSelector(".output input[name=password]"));
		return element.getAttribute("value");
	}
	
	
	
	
	
}
