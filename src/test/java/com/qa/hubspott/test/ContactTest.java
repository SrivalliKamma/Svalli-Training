package com.qa.hubspott.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspott.base.BasepageA;
import com.qa.hubspott.page.ContactA;
import com.qa.hubspott.page.HomepageA;
import com.qa.hubspott.page.LoginpageA;
import com.qa.hubspott.util.Constants;
import com.qa.hubspott.util.ExcelUtility;

public class ContactTest {

	BasepageA basepg;
	Properties propq;
	WebDriver driver;
	LoginpageA lp;
	HomepageA hp;
	ContactA cp;
	
	
	@BeforeMethod
	public void setup() {
		basepg = new BasepageA();
		propq = basepg.initializingProperties();
		String browserN = propq.getProperty("browser");
		driver = basepg.initializedriver(browserN);
		driver.get(propq.getProperty("url"));
		
		lp = new LoginpageA(driver);
		hp = lp.doLogin(propq.getProperty("uname"), propq.getProperty("pawrd"));
		cp = hp.getContactpage();
		
		}
	
	@Test (priority =1)
	public void verfiycontactpagetitle() {
		assertEquals(cp.verifyPagetitle(), Constants.Contact_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] dataprovider() {
		Object data[][] =  ExcelUtility.gettestdata(Constants.Test_Data_sheet);
	return data;
	}

	@Test (priority =2, dataProvider = "dataprovider")
	public void crcontact(String email, String firstname, String lastname, String jobtitle) {
		
		cp.CreateContact(email,firstname,lastname,jobtitle);
		
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
	
	
}
