package password_tes;

import jdk.nashorn.internal.runtime.WithObject;
import objects.PasswordPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class angel_test {

	private WebDriver driver;
	private PasswordPage passwordForm;

	@BeforeClass
	public void start_up() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse\\lib\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		passwordForm = new PasswordPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		driver.get("http://angel.net/~nic/passwd.current.html");
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("form.callout input[name=master]")));
		driver.manage().window().maximize();

	}

	@Test
	public void testGenerationPassword() {

		passwordForm.setMasterPassword("qwerty");
		passwordForm.setSiteName("123@mailinator.com");
		passwordForm.clickGenerate();

		String pass = passwordForm.getPassword();
		
		// passwordForm.setMasterPassword("qwerty");
		// passwordForm.setSiteName("123@mailinator.com");
		// passwordForm.clickGenerate();

		// String pass1 = passwordForm.getPassword();
		// Assert.assertEquals(pass, pass1);
		// System.out.println(pass + "+" + pass1);

		Assert.assertEquals(pass, "FtXaUrqbQsKhT@1a");
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
