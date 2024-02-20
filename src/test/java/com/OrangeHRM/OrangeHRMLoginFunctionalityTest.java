package com.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class OrangeHRMLoginFunctionalityTest extends BaseTest {
	
	OrangeHRMMethods loginPage;
	
	@Test(priority=1,description="Validating the Login Page")
	public void loginPageValidatonTest() throws IOException
	{
		loginPage=new OrangeHRMMethods();
		loginPage.loginPageValidation();
	}
	
	@Test(priority=2,description="Login Functionality Test with Valid test data")
	public void loginFunctionalityTest()
	{
		loginPage.loginFunctionality();
	}
	
	@Test(priority=3,description="Validating Home page")
	public void homePageValidationTest() throws InterruptedException
	{
		String expected_HomePageURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		
		String actual_HomePageURLAddress=driver.getCurrentUrl();
		
		if(actual_HomePageURLAddress.equals(expected_HomePageURLAddress))
		{
			loginPage.homePageValidation();
			Log.info("Successfully Navigated to Home Page: PASS");
			loginPage.logOut();
		}
		else
		{
			Log.info("Failed to navigated to home page: FAIL");
		}
		
	}

}
