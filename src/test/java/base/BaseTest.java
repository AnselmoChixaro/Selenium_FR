package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr ;
	public static FileReader locFr ;
	
	@BeforeMethod
	public void Setup() throws IOException {
	
		if(driver==null) {
			fr = new FileReader( System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
			locFr = new FileReader( System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties");
			
			prop.load(fr);
			loc.load(locFr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager
	        .chromedriver()
	        .capabilities(new ChromeOptions().addArguments("--headless=new"))
	        .clearDriverCache()
	        .clearResolutionCache()
	        .create(); // base
			
			driver = new ChromeDriver();
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager
	        .firefoxdriver()
	        .capabilities(new ChromeOptions().addArguments("--headless=new"))
	        .clearDriverCache()
	        .clearResolutionCache()
	        .create(); // base
			
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("testurl"));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
