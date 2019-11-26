package com.qa.hubspott.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasepageA {
	WebDriver driver;
	Properties prop;
	public WebDriver initializedriver(String BrowserName) {
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","F:/KT/chromedriver/chromedriver.exe" );
			driver = new ChromeDriver();
			}
		else if (BrowserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		else {
			System.out.println("Entered Browser name is not compatiable");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	public Properties initializingProperties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("F:/JavaParctice/svalliPOMsession/src/main/java/com/qa/hubspott/config/config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
			System.out.println("File does not exist, Please Check and propvide the config file");
		} catch (IOException e) {
			System.out.println("value form config file is not loaded");
			} return prop;
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
