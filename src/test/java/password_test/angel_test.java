package password_test;

import jdk.nashorn.internal.runtime.WithObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class angel_test {

	WebDriver driver;

	@BeforeClass
	public void start_up() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse\\lib\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.get("http://angel.net/~nic/passwd.current.html");
		driver.manage().window().maximize();

	}

	@Test
	public void AngelTest() throws InterruptedException {

		driver.findElement(By.name("master")).sendKeys("qwe");
		driver.findElement(By.name("site")).sendKeys("123@mailinator.com");
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		Thread.sleep(1000);
		String a = driver.findElement(By.cssSelector("input[name= password]"))
				.getAttribute("value");
		System.out.println("sample is" + a);

		driver.navigate().refresh();

		driver.findElement(By.name("master")).sendKeys("qwe");
		Thread.sleep(1000);
		driver.findElement(By.name("site")).sendKeys("123@mailinator.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		Thread.sleep(1000);

		Assert.assertEquals(a,driver.findElement(By.cssSelector("input[name= password]")).getAttribute("value"));

		

		Assert.assertTrue(a.endsWith("@1a")); 

	}

	@AfterClass
	public void shut_down() {

		driver.quit();

	}

}
