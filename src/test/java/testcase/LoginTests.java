package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class LoginTests extends BaseTest {
	
	@Test(dataProviderClass=ReadXLSData.class, dataProvider="loginData")
	public static void LoginTest(String username, String password) throws InterruptedException {
		 driver.findElement(By.className(loc.getProperty("login_sign_in_btn"))).click(); // locators  --properties or external java class
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("login_email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("login_next_btn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("login_password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_next_btn"))).click();
	}
}
