package com.OrangeHRM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;

public class EmployeeListTest extends BaseTest {
	
	OrangeHRMMethods employeeListPage;
	
	@Test(priority=1,description="Login Functionality Test with Valid test data")
	public void loginFunctionalityTest() throws IOException
	{
		employeeListPage = new OrangeHRMMethods();
		employeeListPage.loginFunctionality();
	}
	
	@Test(priority=2,description="Mouse hover action on pim_menu")
	public void pimMenuTest() throws IOException, InterruptedException
	{
		employeeListPage.pimMenu();
	}
	
	@Test(priority=3,description="Performing click operation on Add Employee")
	public void employeeListClickTest() 
	{
		employeeListPage.employeeListClick();
	}
	
	@Test(priority=4,description="Printing employee list details")
	public void employeeListValidationTest()
	{
		employeeListPage.employeeListValidation();
	}

}
