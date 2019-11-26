package com.qa.hubspott.test;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hubspott.base.BasepageA;
import com.qa.hubspott.page.HomepageA;
import com.qa.hubspott.page.LoginpageA;
import com.qa.hubspott.util.Constants;
import junit.framework.Assert;
public class HomepageTest {
	BasepageA basepg;
	Properties propq;
	WebDriver driver;
	LoginpageA lp;
	HomepageA hp;
	@BeforeTest
	public void setup() {
		basepg = new BasepageA();
		propq = basepg.initializingProperties();
		String browserN = propq.getProperty("browser");
		driver = basepg.initializedriver(browserN);
		driver.get(propq.getProperty("url"));
		lp = new LoginpageA(driver);
		hp = lp.doLogin(propq.getProperty("uname"), propq.getProperty("pawrd"));
		}
	@Test(priority = 1)
	public void homepgtitleverify() {
		Assert.assertEquals( hp.verfiyTittlehp(), Constants.Home_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void headerverification() {
		Assert.assertTrue(hp.isHeaderPresent());
		Assert.assertEquals( hp.getHeaderText(),Constants.Homepage_Headers);
		System.out.println(hp.getHeaderText());
	}
	@Test (priority = 3)
	public void isAccountnamepresent() {
		Assert.assertTrue(hp.isaccountNamePresent());
		Assert.assertEquals(propq.getProperty("accountName"), hp.getaccountName() );
	}
	@AfterTest
	public void teardown(){
		driver.quit();
	}
	

}
