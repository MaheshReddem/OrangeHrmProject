package com.OrangeHRM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class OrangeHRMPersonalDetailsPageTest extends BaseTest {
	
	OrangeHRMMethods personalDetailsPage;
	
	@Test(priority=1,description="Login Functionality Test with Valid test data")
	public void loginFunctionalityTest()
	{
		personalDetailsPage=new OrangeHRMMethods();
		
		personalDetailsPage.loginFunctionality();;
	}
	
	@Test(priority=2,description="Mouse hover action on pim_menu")
	public void pimMenuTest() throws IOException, InterruptedException
	{
		personalDetailsPage.pimMenu();
	}
	
	@Test(priority=3,description="Performing click operation on Add Employee")
	public void addEmployeeClickValidationTest()
	{
		personalDetailsPage.addEmployeeClickValidation();
	}
	
	@Test(priority=4,description="Adding new employee")
	public void addingNewEmployeeTest() throws IOException, InterruptedException
	{
		personalDetailsPage.addingNewEmployee();
	}
	
	@Test(priority=5,description="Validating personal details page")
	public void personalDetailsPageValidationTest()
	{
		personalDetailsPage.personalDetailsPageValidation();
		
		Log.info("Personal details page validation successful");
	}
	
	@Test(priority=6,description="Validating personal details")
	public void personalDetailsValidationTest()
	{
		personalDetailsPage.personalDetailsFirstNameValidation();
		personalDetailsPage.personalDetailsMiddleNameValidation();
		personalDetailsPage.personalDetailsLastNameValidation();
		personalDetailsPage.personalDetailsEmployeeIDValidation();
	}
	
	@Test(priority=7,description="Logout validation")
	public void logOutTest() throws InterruptedException
	{
		personalDetailsPage.logOut();
	}
	
	

}
