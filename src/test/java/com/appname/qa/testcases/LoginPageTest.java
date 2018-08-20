package com.appname.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.appname.qa.base.TestBase;
import com.appname.qa.pages.HomePage;
import com.appname.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// obj of login page
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test (priority = 2)
	public void LogoImageTest() {
		Boolean logo = loginPage.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void LoginTest() {
		homePage = loginPage.Login(prop.getProperty("Username").toString(), prop.getProperty("Password").toString());
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
}

