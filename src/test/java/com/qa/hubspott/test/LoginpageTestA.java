package com.qa.hubspott.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hubspott.base.BasepageA;
import com.qa.hubspott.page.LoginpageA;
import com.qa.hubspott.util.Constants;
import junit.framework.Assert;
public class LoginpageTestA {
	BasepageA basepg;
	Properties propq;
	WebDriver driver;
	LoginpageA lp;
	@BeforeTest
	public void setup() {
		basepg = new BasepageA();
		propq = basepg.initializingProperties();
		String browserN = propq.getProperty("browser");
		driver = basepg.initializedriver(browserN);
		driver.get(propq.getProperty("url"));
		lp = new LoginpageA(driver);
	} 
	@Test(priority = 1)
	public void loginpagetittle(){
		Assert.assertEquals(lp.verifyPageTitle(), Constants.Login_PAGE_TITLE);
		}
	@Test(priority = 2)
	public void signuplinkisPresent() {
		
		Assert.assertTrue(lp.verfiySignupLink());
	}
	@Test(priority=3)
	public void dologin(){
		lp.doLogin(propq.getProperty("uname"), propq.getProperty("pawrd"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
