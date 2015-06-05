package password_tes;

import java.util.concurrent.TimeUnit;

import jdk.nashorn.internal.runtime.WithObject;
import objects.PasswordPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class angel_test {

	 WebDriver driver;
	 PasswordPage passwordForm;

	@BeforeClass
	public void start_up() throws InterruptedException {

	
		//System.setProperty("webdriver.chrome.driver",
			//	"D:\\eclipse\\lib\\chromedriver.exe");

		driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
		passwordForm = new PasswordPage(driver);
		
		driver.get("http://oxogamestudio.com/passwd.current7.htm");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By
				//.cssSelector("form.callout input[name=master]")));
		passwordForm= PageFactory.initElements(driver, PasswordPage.class);
	
		
		driver.manage().window().maximize();
		
	}

	@Test
	public void testGenerationPassword() throws InterruptedException {

	//	WebElement myElement = (new WebDriverWait(driver,1)).
				//until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form.callout input[name=master]")));
		
		passwordForm.setMasterPassword("qwerty");
	
		passwordForm.setSiteName("123@mailinator.com");
		
		passwordForm.clickGenerate();		

		String pass = passwordForm.getPassword();
		
		// passwordForm.setMasterPassword("qwerty");
		// passwordForm.setSiteName("123@mailinator.com");
		// passwordForm.clickGenerate();

		// String pass1 = passwordForm.getPassword();
		// Assert.assertEquals(pass, pass1);
		System.out.println(pass + "******************************************************************************");

		Assert.assertEquals(pass, "FtXaUrqbQsKhT@1a");
		passwordForm.RefreshPage();
	}

	@Test
	public void testEquals() {

		passwordForm.setMasterPassword("qwerty");
		passwordForm.setSiteName("123@mailinator.com");
		passwordForm.clickGenerate();
		String code1 = passwordForm.getPassword();
		passwordForm.RefreshPage();
		passwordForm.setMasterPassword("qwerty");
		passwordForm.setSiteName("123@mailinator.com");
		passwordForm.clickGenerate();
		String code2 = passwordForm.getPassword();

		Assert.assertEquals(code1, code2);
		passwordForm.RefreshPage();

	}

	@Test
	public void testSuffix() {
		passwordForm.setMasterPassword("qwerty");
		passwordForm.setSiteName("123@mailinator.com");
		passwordForm.clickGenerate();
		String code = passwordForm.getPassword();

		Assert.assertTrue(code.endsWith("@1a"));
	}

	/*
	 * @Test public void AngelTest() throws InterruptedException {
	 * 
	 * driver.findElement(By.name("master")).sendKeys("qwe");
	 * driver.findElement(By.name("site")).sendKeys("123@mailinator.com");
	 * driver.findElement(By.cssSelector("input[type=submit]")).click();
	 * Thread.sleep(1000); String a =
	 * driver.findElement(By.cssSelector("input[name= password]"))
	 * .getAttribute("value"); System.out.println("sample is" + a);
	 * 
	 * driver.navigate().refresh();
	 * 
	 * driver.findElement(By.name("master")).sendKeys("qwe");
	 * Thread.sleep(1000);
	 * driver.findElement(By.name("site")).sendKeys("123@mailinator.com");
	 * Thread.sleep(1000);
	 * driver.findElement(By.cssSelector("input[type=submit]")).click();
	 * Thread.sleep(1000);
	 * 
	 * Assert.assertEquals(a,driver.findElement(By.cssSelector(
	 * "input[name= password]")).getAttribute("value"));
	 * 
	 * 
	 * 
	 * Assert.assertTrue(a.endsWith("@1a"));
	 * 
	 * }
	 */

	@AfterClass
	public void shut_down() {

		driver.quit();

	}

}
