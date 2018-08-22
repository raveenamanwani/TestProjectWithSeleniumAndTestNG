package com.appname.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.ContactsPage;
import com.appname.qa.pages.HomePage;
import com.appname.qa.pages.LoginPage;
import com.appname.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		// obj of login page
		
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("Username").toString(), prop.getProperty("Password").toString());
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	

	@Test(priority = 1) 
	public void validateCreateNewContactTest() {
	homePage.clickOnNewContactsLink();
	contactsPage.createNewContact("Mr.", "ABC", "XYZ", "Amazon");
	}
	
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
	
}
