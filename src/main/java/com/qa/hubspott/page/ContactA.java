package com.qa.hubspott.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspott.base.BasepageA;
import com.qa.hubspott.util.Constants;
import com.qa.hubspott.util.ElementUtil;

public class ContactA extends BasepageA{
	
	WebDriver driver;
	ElementUtil el;
	
	
	By crtcontact  = By.xpath("//span[contains(text(), 'Create contact')]");
	By email = By.xpath("//input[@data-field = 'email']");
	By fname = By.xpath("//input[@data-field = 'firstname']");
	By lname = By.xpath("//input[@data-field = 'lastname']");
	By jobtitle = By.xpath("//input[@data-field = 'jobtitle']");
	By SubmitBtn = By.xpath("(//span[contains(text(),'Create contact')])[2]");
	
	public ContactA(WebDriver driver) {
		this.driver = driver;
		el = new ElementUtil(driver);
	}
	
	public String verifyPagetitle() {
		return el.getTittleExplicit(Constants.Contact_PAGE_TITLE, 15);
	}
	public void CreateContact(String emailid, String ftname, String ltname, String Jtitle) {
		el.explicitWait(crtcontact, 20);
		el.doActionClick(crtcontact);
		
		el.explicitWait(email, 20);
		el.sendKeys(email, emailid);
		el.explicitWait(fname, 20);
		el.sendKeys(fname, ftname);
		el.explicitWait(lname, 20);
		el.sendKeys(lname, ltname);
		el.explicitWait(jobtitle, 20);
		el.sendKeys(jobtitle, Jtitle);
		el.explicitWait(SubmitBtn, 20);
		
		el.doActionClick(SubmitBtn);
		
		
	}
	
	
	
	
	

}
