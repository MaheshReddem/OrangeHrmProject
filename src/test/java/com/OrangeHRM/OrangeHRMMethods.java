package com.OrangeHRM;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class OrangeHRMMethods extends BaseTest {
	
	Actions pimActions;
	
	
	public void loginPageValidation() throws IOException
	{
		String expected_LoginPageText="LOGIN Panel";
		Log.info("The expected login page text is: "+expected_LoginPageText);
		
		By orangeHRMLoginPanelProperty=By.xpath(properties.getProperty("orangeHRMLoginPanelProperty"));
		WebElement orangeHRMLoginPanel=driver.findElement(orangeHRMLoginPanelProperty);
		String actual_LoginPageText=orangeHRMLoginPanel.getText();
		Log.info("The actual login page text is: "+actual_LoginPageText);
		
//		try
//		{
//		Assert.assertEquals(actual_LoginPageText, expected_LoginPageText);
//		}
//		
//		catch(Throwable t)
//		{
//			System.out.println(t.getMessage());
//			System.out.println(t.toString());
//		}
		
		if(actual_LoginPageText.equals(expected_LoginPageText))
		{
			Log.info("Successfully navigated to Login Page: PASS");
		}
		else
		{
			Log.info("Failed to navigate to Login Page: FAIL");
		}
		
	}
	
	
	public void loginFunctionality()
	{
		String userName_TestData="Mahesh20";
		By orangeHRMUserNameProperty=By.xpath(properties.getProperty("orangeHRMUserNameProperty"));
		WebElement orangeHRMUserName=driver.findElement(orangeHRMUserNameProperty);
		orangeHRMUserName.sendKeys(userName_TestData);
		
		String password_TestData="Mahesh@20";
		By orangeHRMPasswordProperty=By.xpath(properties.getProperty("orangeHRMPasswordProperty"));
		WebElement orangeHRMPassword=driver.findElement(orangeHRMPasswordProperty);
		orangeHRMPassword.sendKeys(password_TestData);
		
		By orangeHRMLoginButtonProperty=By.xpath(properties.getProperty("orangeHRMLoginButtonProperty"));
		WebElement orangeHRMLoginButton=driver.findElement(orangeHRMLoginButtonProperty);
		orangeHRMLoginButton.click();
		
		Log.info("UserName: "+userName_TestData+", Password: "+password_TestData);
	}
	
	public void homePageValidation()
	{
		String expected_HomePageText="Dashboard";
		Log.info("The expected home page text is: "+expected_HomePageText);
		
		By orangeHRMHomePageDashboardProperty=By.xpath(properties.getProperty("orangeHRMHomePageDashboardProperty"));
		WebElement orangeHRMHomePageDashboard=driver.findElement(orangeHRMHomePageDashboardProperty);
		String actual_orangeHRMHomePageText=orangeHRMHomePageDashboard.getText();
		Log.info("The actual home page text is: "+actual_orangeHRMHomePageText);
		
	}
	
	public void logOut() throws InterruptedException
	{
		By orangeHRMHomePageWelComeAdminProperty=By.xpath(properties.getProperty("orangeHRMHomePageWelComeAdminProperty"));
		WebElement orangeHRMHomePageWelComeAdmin=driver.findElement(orangeHRMHomePageWelComeAdminProperty);
		orangeHRMHomePageWelComeAdmin.click();
		
		By orangeHRMHomePageLogOutProperty=By.linkText(properties.getProperty("orangeHRMHomePageLogOutProperty"));
		WebElement orangeHRMHomePageLogOut=driver.findElement(orangeHRMHomePageLogOutProperty);
		orangeHRMHomePageLogOut.click();
		
	}
	
	
	public void pimMenu() throws IOException, InterruptedException
	{
		By orangeHRMPIMmenuProperty=By.id(properties.getProperty("orangeHRMHomePagePIMMenuProperty"));
		WebElement orangeHRMPIMmenu=driver.findElement(orangeHRMPIMmenuProperty);
		
		pimActions = new Actions(driver);
		pimActions.moveToElement(orangeHRMPIMmenu).build().perform();
		
	}
	
	public void addEmployeeClickValidation()
	{
		By orangeHRMHomePageAddEmployeeProperty=By.id(properties.getProperty("orangeHRMHomePageAddEmployeeProperty"));
		WebElement orangeHRMHomePageAddEmployee=driver.findElement(orangeHRMHomePageAddEmployeeProperty);
		orangeHRMHomePageAddEmployee.click();
	}	
	
	String expected_FirstName_TestData;
	String expected_MiddleName_TestData;
	String expected_LastName_TestData;
	String expected_EmployeeID;
	
	public void addingNewEmployee() throws IOException, InterruptedException
	{
		expected_FirstName_TestData="Mahi";
		By orangeHRMFirstNameProperty=By.id(properties.getProperty("orangeHRMFirstNameProperty"));
		WebElement orangeHRMFirstName=driver.findElement(orangeHRMFirstNameProperty);
		orangeHRMFirstName.sendKeys(expected_FirstName_TestData);
		
		pimActions.sendKeys(Keys.TAB).build().perform();
		expected_MiddleName_TestData="Mahi";
		pimActions.sendKeys(expected_MiddleName_TestData).build().perform();
		
		pimActions.sendKeys(Keys.TAB).build().perform();
		expected_LastName_TestData="Reddy";
		pimActions.sendKeys(expected_LastName_TestData).build().perform();
		
		pimActions.sendKeys(Keys.TAB).build().perform();
		
		By orangeHRMEmployeeIDProperty=By.id(properties.getProperty("orangeHRMEmployeeIDProperty"));
		WebElement orangeHRMEmployeeID=driver.findElement(orangeHRMEmployeeIDProperty);
		expected_EmployeeID=orangeHRMEmployeeID.getAttribute("value");
		
		Log.info("Expected first name is: "+expected_FirstName_TestData+", Expected middle name is: "+expected_MiddleName_TestData+", Expected last name is: "+expected_LastName_TestData);
		Log.info("Expected employee ID is: "+expected_EmployeeID);
		
		pimActions.sendKeys(Keys.TAB).build().perform();
		pimActions.sendKeys(Keys.ENTER).build().perform();
		
		java.lang.Runtime.getRuntime().exec("./Photograph/Venkat.exe");
		
		Thread.sleep(2000);
		
		By orangeHRMAddEmployeeSaveButtonProperty=By.id(properties.getProperty("orangeHRMAddEmployeeSaveButtonProperty"));
		WebElement orangeHRMAddEmployeeSaveButton=driver.findElement(orangeHRMAddEmployeeSaveButtonProperty);
		orangeHRMAddEmployeeSaveButton.click();
		
		Thread.sleep(2000);
	}	
	
	
	public void personalDetailsPageValidation()
	{
		String expected_personalDetailsPageText="Personal Details";
		Log.info("The expected text of personal details page is: "+expected_personalDetailsPageText);
		
		By personalDetailsPageTextProperty=By.xpath(properties.getProperty("personalDetailsPageTextProperty"));
		WebElement personalDetails=driver.findElement(personalDetailsPageTextProperty);
		String actual_personalDetailsPageText=personalDetails.getText();
		Log.info("The actual text of personal details page is: "+actual_personalDetailsPageText);
		
		if(actual_personalDetailsPageText.equals(expected_personalDetailsPageText))
		{
			Log.info("Successfully Navigated to personal details page: PASS");
		}
		else
		{
			Log.info("Failed to navigate to personal details page: FAIL");
		}
		
	}
	
	String actual_FirstName;
	public void personalDetailsFirstNameValidation()
	{
		By orangeHRMPersonalDetailsPageFirstNameProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageFirstNameProperty"));
		WebElement orangeHRMPersonalDetailsPageFirstName=driver.findElement(orangeHRMPersonalDetailsPageFirstNameProperty);
		actual_FirstName=orangeHRMPersonalDetailsPageFirstName.getAttribute("value");
		
		if(actual_FirstName.equals(expected_FirstName_TestData))
		{
			Log.info("First name matches");
		}
		else
		{
			Log.info("First name does not match");
		}
	}
	
	String actual_MiddleName;
	public void personalDetailsMiddleNameValidation()
	{		
		By orangeHRMPersonalDetailsPageMiddleNameProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageMiddleNameProperty"));
		WebElement orangeHRMPersonalDetailsPageMiddleName=driver.findElement(orangeHRMPersonalDetailsPageMiddleNameProperty);
		actual_MiddleName=orangeHRMPersonalDetailsPageMiddleName.getAttribute("value");
		
		if(actual_MiddleName.equals(expected_MiddleName_TestData))
		{
			Log.info("Middle name matches");
		}
		else
		{
			Log.info("Middle name does not match");
		}
	}
	
	String actual_LastName;
	public void personalDetailsLastNameValidation()
	{
		By orangeHRMPersonalDetailsPageLastNameProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageLastNameProperty"));
		WebElement orangeHRMPersonalDetailsPageLastName=driver.findElement(orangeHRMPersonalDetailsPageLastNameProperty);
		actual_LastName=orangeHRMPersonalDetailsPageLastName.getAttribute("value");
		
		Assert.assertEquals(actual_LastName, expected_LastName_TestData);
	}	
	
	String actual_EmployeeID;
	public void personalDetailsEmployeeIDValidation()
	{
		By orangeHRMPersonalDetailsPageEmployeeIDProperty=By.id(properties.getProperty("orangeHRMPersonalDetailsPageEmployeeIDProperty"));
		WebElement orangeHRMPersonalDetailsPageEmployeeID=driver.findElement(orangeHRMPersonalDetailsPageEmployeeIDProperty);
		actual_EmployeeID=orangeHRMPersonalDetailsPageEmployeeID.getAttribute("value");
		
		Assert.assertEquals(actual_EmployeeID, expected_EmployeeID);
		
		Log.info("Actual first name is: "+actual_FirstName+", Actual middle name is: "+actual_MiddleName+", Actual last name is: "+actual_LastName);
		Log.info("Actual employee ID is: "+actual_EmployeeID);
	}
	
	public void employeeListClick()
	{
		By employeeListProperty=By.id("menu_pim_viewEmployeeList");
		WebElement employeeList=driver.findElement(employeeListProperty);
		employeeList.click();
	}
	
	/*
	public void employeeListPageValidation()
	{
		String expected_EmployeeListPageText="Employee Information";
		Log.info("The expected text of employee list page is: "+expected_EmployeeListPageText);
		
		By employeeListPageTextProperty=By.id("employee-information");
		WebElement employeeListPageText=driver.findElement(employeeListPageTextProperty);
		String actual_employeeListPageTextProperty=employeeListPageText.getText();
		Log.info("The actual login page text is: "+actual_employeeListPageTextProperty);
		
		
		if(actual_employeeListPageTextProperty.equals(expected_EmployeeListPageText))
		{
			Log.info("Successfully navigated to Employee List Page");
		}
		else
		{
			Log.info("Failed to navigate to Employee List Page");
		}
				
	}
	*/
	
	public void employeeListValidation()
	{
		By employeeListTableProperty=By.id("frmList_ohrmListComponent");
		WebElement employeeListTable=driver.findElement(employeeListTableProperty);
		
		By employeeListTableRowsProperty=By.tagName("tr");
		List<WebElement> employeeListTableRows=driver.findElements(employeeListTableRowsProperty);
		
		for(int rowIndex=0;rowIndex<employeeListTableRows.size();rowIndex++)
		{
			System.out.println(employeeListTableRows.get(rowIndex).getText());
		}
				
	}
	
	
	
	
}
				
				
