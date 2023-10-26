package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("C:\\Users\\suporte\\Documents\\Git Hub Work Space\\Selenium_Demo_1\\src\\test\\resources\\configFiles\\config.properties");
		
		Properties p = new Properties();
		
		p.load(fr);
		
		p.getProperty("browser");
		p.getProperty("testurl");
	}
}
