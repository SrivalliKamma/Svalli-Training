package com.qa.hubspott.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspott.base.BasepageA;
import com.qa.hubspott.util.Constants;
import com.qa.hubspott.util.ElementUtil;
public class LoginpageA extends BasepageA  {
	WebDriver driver;
	ElementUtil el;
	
	//1. Element Repository/ page library
	By email = By.id("username");
	By passwd  = By.id("password");
	By submit = By.id("loginBtn");
	By signuplink = By.linkText("Sign up");
//2. Need to create the constructor of this class
	public LoginpageA(WebDriver driver) {
		this.driver = driver;
		el = new ElementUtil(driver);
	}
	//3. page action
	public String verifyPageTitle() {
		return  el.getTittleExplicit(Constants.Login_PAGE_TITLE, 15);
		
		
	}
	public boolean verfiySignupLink() {
		return el.isElementDisplayed(signuplink);
		
		}
	public HomepageA doLogin(String uname, String pwd) {
		el.explicitWait(email, 20);
		el.sendKeys(email, uname);
		el.explicitWait(passwd, 20);
		el.sendKeys(passwd, pwd);
		el.explicitWait(submit, 20);
		el.doClick(submit);
		
		return new HomepageA(driver);
	}
	

}
