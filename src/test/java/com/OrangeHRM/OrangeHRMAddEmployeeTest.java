package com.OrangeHRM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class OrangeHRMAddEmployeeTest extends BaseTest {
	
	OrangeHRMMethods addEmployeePage;
	
	@Test(priority=1,description="Login Functionality Test with Valid test data")
	public void loginFunctionalityTest() throws IOException
	{
		addEmployeePage=new OrangeHRMMethods();
		addEmployeePage.loginFunctionality();
		
		Log.info("Login functionality successful");
	}
	
	
	@Test(priority=2,description="Validating home page")
	public void homePageValidationTest() throws InterruptedException, IOException
	{
		String expected_HomePageURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		
		String actual_HomePageURLAddress=driver.getCurrentUrl();
		
		if(actual_HomePageURLAddress.equals(expected_HomePageURLAddress))
		{
			addEmployeePage.homePageValidation();
			Log.info("Successfully Navigated to Home Page: PASS");
		}
		else
		{
			Log.info("Failed to navigated to home page: FAIL");
		}
		
		Log.info("Home page validation successful");
		
	}
	
	@Test(priority=3,description="Validating pim_menu")
	public void pimMenuTest() throws IOException, InterruptedException
	{
		addEmployeePage.pimMenu();
		
		Log.info(" PIM menu validation successful");
	}
	
	@Test(priority=4,description="Validating pim_AddEmployee")
	public void addEmployeeClickValidationTest()
	{
		addEmployeePage.addEmployeeClickValidation();
		
		Log.info("AddEmployee validation successful");
	}
	
	@Test(priority=5,description="Adding a new employee")
	public void addingNewEmployeeTest() throws IOException, InterruptedException
	{
		addEmployeePage.addingNewEmployee();
		
		Log.info("Adding new employee successful");
	}
	

}
