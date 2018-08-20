package com.appname.qa.util;

import com.appname.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public static long PAGE_LOAD_Timeout = 20;
	public static long IMPLICIT_WAIT = 10;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}


}
