package com.appname.qa.base;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.appname.qa.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {

		// read the file properties
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:/Users/DELL/eclipse-workspace/MySeleniumClasses/src/main/java/com/appname/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

public static void initialization(){
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
		driver = new FirefoxDriver();
}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_Timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url").toString());
	//driver.get("https://www.freecrm.com/");
}
}