package com.projectRAK.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectRAK.pageObjects.AddCustomerPage;
import com.projectRAK.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Ajeet kumar singh");
		addcust.custgender("male");
		addcust.custdob("10","02","1996");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("GKP");
		addcust.custstate("UP");
		addcust.custpinno("273002");
		addcust.custtelephoneno("8799672782");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("xyz123");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
