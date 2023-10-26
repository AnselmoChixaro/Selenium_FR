package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTests extends BaseTest {
	
	@Test
	public static void LoginTest() throws InterruptedException {
		driver.get("https://www.zoho.com"); // properties
		driver.findElement(By.className("login")).click(); // locators  --properties or external java class
		Thread.sleep(2000);
		driver.findElement(By.id("login_id")).sendKeys("anselmo.chixaro@gmail.com");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Saori3112!");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
	}
}
