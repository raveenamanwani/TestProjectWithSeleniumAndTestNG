package com.appname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appname.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	
	//PAGE FACTORY: OR:
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//button[contains(text() = 'Sign Up')]")
	WebElement SignUp;
	
	//@FindBy(xpath = "//img[@class='img-responsive']")
	@FindBy(xpath = "//img[contains(@alt, 'free crm logo')]")
	WebElement Logo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		}
	
	public boolean validateLogo() {
		return Logo.isDisplayed(); 
	}
	
	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage(); 
		
	}
	
}


