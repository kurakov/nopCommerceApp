package com.nopcommerce.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;


public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() throws IOException {
		logger.info("************ Starting TC_LoginTest_001 *********");
		driver.get(configProObj.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		
		logger.info("************ Providing user data*********");
		lp.setUserName(configProObj.getProperty("useremail"));
		lp.setPassword(configProObj.getProperty("password"));
		lp.clickLogin();
		
		
		logger.info("************ Verifyinng login *********");
		String expected_title="Dashboard / nopCommerce administration";
		String actual_title=driver.getTitle();
		logger.info("************ Login is passed *********");
		if(expected_title.equals(actual_title)) {
			Assert.assertTrue(true);
			}else {
				captureScreen(driver, "loginTest");//call this method on fail
				logger.warn("************ Logins is faile *********");
				Assert.assertFalse(false);
		}
		logger.info("************ Finished TC_LoginTest_001 *********");
	}
}
