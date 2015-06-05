package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {

	private final WebDriver driver;

	public PasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "form.callout input[name=master]")
	private WebElement setMasterPassword;

	@FindBy(css = "form.callout input[name=site]")
	private WebElement setSiteName;

	@FindBy(css = "form.callout input[type=submit]")
	private WebElement clickGenerate;

	@FindBy(css = ".output input[name=password]")
	private WebElement password;

	public void setMasterPassword(String value) {

		try {
			setMasterPassword.sendKeys(value);
		} catch (Exception ex) {
			// System.out.println(ex.toString());
			// System.out.println("***************************************************");

			driver.findElement(
					By.xpath("//form//tr[1]/td[2]/input"))
					.sendKeys(value);
		}
	}

	public void setSiteName(String value) {
		try {
			setSiteName.sendKeys(value);
		} catch (Exception ex) {
			driver.findElement(
					By.xpath("//form//tr[2]/td[2]/input"))
					.sendKeys(value);
		}
	}

	public void clickGenerate() {
		
		try {
			
			clickGenerate.click();
			
		} catch (Exception ex) {
			
			driver.findElement(By.xpath("//form//tr[3]/td/input]")).click();
		
			
		}
		
	}

	public boolean isPasswordTextEmpty() {
		
		return password.getAttribute("value").isEmpty();
	}

	public String getPassword() {
		try {
			
			return password.getAttribute("value");
		} catch (Exception ex) {
			
			return 
					driver.findElement(By.xpath("//form//tr[4]/td[2]/input"))
					.getAttribute("value");
			
		}

	}

	public void RefreshPage() {
		driver.navigate().refresh();
	}

	public void cleanUp() {
		setMasterPassword.clear();
		setSiteName.clear();
		password.clear();

	}

}

/*
 * private WebDriver driver; do pererabotki
 * 
 * public PasswordPage(WebDriver driver2) { this.driver = driver2; }
 * 
 * 
 * public void setMasterPassword(String password) { WebElement element =
 * driver.findElement(By.cssSelector("form.callout input[name=master]")); if
 * (password == "") { element.clear(); } else { element.clear();
 * element.sendKeys(password); } }
 * 
 * public void setSiteName(String siteName) { WebElement element =
 * driver.findElement(By.cssSelector("form.callout input[name=site]")); if
 * (siteName == "") { element.clear(); } else { element.clear();
 * element.sendKeys(siteName); } }                                                //td[text()=\"Site name\"]/../preceding::input[1]"
 * 
 * public void clickGenerate() { //click("rre");
 * 
 * click(By.cssSelector("form.callout input[type=submit]"),driver); try{         xpath //td[text()=\"Your master password\"]/../following::input[1]
 * Thread.sleep(2000); }catch(Exception ex){} }
 * 
 * 
 * 
 * public void clearPassword() throws InterruptedException{
 * driver.findElement(By.cssSelector(".output input[name=password]")).clear();
 * Thread.sleep(4000); }
 * 
 * 
 * public void RefreshPage(){ driver.navigate().refresh(); }
 * 
 * public String getPassword() { WebElement element =
 * driver.findElement(By.cssSelector(".output input[name=password]")); return
 * element.getAttribute("value"); }
 * 
 * 
 * 
 * 
 * 
 * }
 */