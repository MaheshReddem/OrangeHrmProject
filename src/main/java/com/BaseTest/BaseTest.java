package com.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
	
	public static WebDriver driver;
	public static FileInputStream propertiesFile;
	public static Properties properties;
	
	@BeforeTest
	public void applicationSetUp() throws IOException
	{
		propertiesFile=new FileInputStream("./src/main/java/com/Config/OrangeHRMApp.properties");
		
		properties = new Properties();
		properties.load(propertiesFile);
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		System.out.println("******Browser launch successful******");
		
		String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(applicationURLAddress);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("******Browser close successful******");
	}

}
