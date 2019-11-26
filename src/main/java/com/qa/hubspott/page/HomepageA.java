package com.qa.hubspott.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspott.base.BasepageA;
import com.qa.hubspott.util.Constants;
import com.qa.hubspott.util.ElementUtil;
public class HomepageA extends BasepageA{
	WebDriver driver;
	ElementUtil el;
	//1. page lib/repo
	By header =  By.className("private-page__title");
	By Acountmenu = By.xpath("//a[@id = 'account-menu']");
	By Accountname = By.className("user-info-name");
	
	By primarycontact = By.id("nav-primary-contacts-branch");
	By SecContact = By.id("nav-secondary-contacts");
	
//	2. Constructor for current class
	
	public HomepageA(WebDriver driver) {
		this.driver = driver;
		 el = new ElementUtil(driver);
		}
	//3. Define Actions
	public String verfiyTittlehp() {
		return el.getTittleExplicit(Constants.Home_PAGE_TITLE, 15);
		
	}
	public boolean isHeaderPresent() {
		
		return el.isElementDisplayed(header);
		
	}
	public String getHeaderText() {
		return el.getElementText(header);
		
	}
	public boolean isaccountNamePresent() {
		
		el.doClick(Acountmenu);
		return el.isElementDisplayed(Accountname);
		
	}
	public String getaccountName() {
		return el.getElementText(Accountname);
		}
	
	public void contactclick() {
		
		el.explicitWait(primarycontact, 20);
		el.doActionClick(primarycontact);
		
		el.explicitWait(SecContact, 20);
		el.doActionClick(SecContact);
		//return new ContactA(driver);
	}
	public ContactA getContactpage() {
		contactclick();
		return new ContactA(driver);
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
