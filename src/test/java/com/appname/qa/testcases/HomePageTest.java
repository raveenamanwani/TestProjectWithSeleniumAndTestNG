package com.appname.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.HomePage;
import com.appname.qa.pages.LoginPage;
import com.appname.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		// obj of login page
		testUtil = new TestUtil();
		loginPage = new LoginPage();
	homePage = loginPage.Login(prop.getProperty("Username").toString(), prop.getProperty("Password").toString());
	
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
	String HomePageTitle = homePage.verifyHomePageTitle();
	Assert.assertEquals(HomePageTitle, "CRMPRO");
		
	}
	
	@Test (priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
	
	
	
}
