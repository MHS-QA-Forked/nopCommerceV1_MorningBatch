package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		logger.info("open URL");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickLogin();
		logger.info("clciked on login");
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login test passed");
			logger.info("Logout clicked");
		}
		else
		{
			captureScreen(driver,"loginTest");
			logger.error("Login test failed");
			logger.info("Logout clicked");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
