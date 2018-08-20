package com.appname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appname.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(), 'User: Raveena Manwani')]")
	WebElement UserNameLabel;
	
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact']")
	WebElement NewContactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement DealsLink;
	
	
	//constructor of Home Page
	
	public void HomePage() {
		PageFactory.initElements(driver, this); 
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return UserNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		ContactsLink.click();
		return new DealsPage();
		
	}
	
	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();
		
	}
	
	
	
}
