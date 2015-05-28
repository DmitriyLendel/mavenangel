package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bindigs {
	
	public  void click(By element, WebDriver driver)
	{
			driver.findElement(element).submit();	
	}
	

}
