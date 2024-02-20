package com.OrangeHRM;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class LeaveMenu extends BaseTest {
	
	@Test
	public void loginFunctionalityTest()
	{
		String userName_TestData="Mahesh20";
		By orangeHRMUserNameProperty=By.id("txtUsername");
		WebElement orangeHRMUserName=driver.findElement(orangeHRMUserNameProperty);
		orangeHRMUserName.sendKeys(userName_TestData);
		
		String password_TestData="Mahesh@20";
		By orangeHRMPasswordProperty=By.id("txtPassword");
		WebElement orangeHRMPassword=driver.findElement(orangeHRMPasswordProperty);
		orangeHRMPassword.sendKeys(password_TestData);
		
		By orangeHRMLoginButtonProperty=By.id("btnLogin");
		WebElement orangeHRMLoginButton=driver.findElement(orangeHRMLoginButtonProperty);
		orangeHRMLoginButton.click();
		
		Log.info("UserName: "+userName_TestData+", Password: "+password_TestData);
	}
	
	@Test
	public void orangeHRMLeave()
	{
		By leaveMenuProperty=By.id("menu_leave_viewLeaveModule");
		WebElement leaveMenu=driver.findElement(leaveMenuProperty);
		leaveMenu.click();
	}
	
	
	@Test
	public void selectMonth() throws InterruptedException
	{
		By selectMonthProperty=By.id("leaveperiod_cmbStartMonth");
		WebElement selectMonth=driver.findElement(selectMonthProperty);
		
		By selectMonthsListProperty=By.tagName("option");
		List<WebElement> selectMonthsList=selectMonth.findElements(selectMonthsListProperty);
		int totalNoOfMonths=selectMonthsList.size();
		Log.info("The total no of months in the list is: "+totalNoOfMonths);
		System.out.println("The fifth month is: "+selectMonthsList.get(5).getText());
		
		/*
		for(int index=0;index<selectMonthsList.size();index++)
		{
			String monthNames=selectMonthsList.get(index).getText();
			Log.info(index+" - "+monthNames);
		}
		
		Select monthSelect=new Select(selectMonth);
		monthSelect.selectByVisibleText("May");
		*/
		
		Iterator<WebElement> monthsNames=selectMonthsList.iterator();
		
		while(monthsNames.hasNext())
		{
			String names=monthsNames.next().getText();
			Log.info(names);
			
		}
		
		Thread.sleep(3000);
		
	}
	
	
	
	public void selectDate() throws InterruptedException
	{
		By selectDatesProperty=By.id("leaveperiod_cmbStartDate");
		WebElement selectDates=driver.findElement(selectDatesProperty);
		
		By dateProperty=By.tagName("option");
		List<WebElement> dates=selectDates.findElements(dateProperty);
		
		
		for(int datesIndex=1;datesIndex<dates.size();datesIndex++)
		{
			Log.info(dates.get(datesIndex).getText());
		}
		
		Select dateSelect=new Select(selectDates);
		dateSelect.selectByValue("4");
		
		Thread.sleep(3000);
		
	}
	public void saveLeave()
	{
	
	}	

}
