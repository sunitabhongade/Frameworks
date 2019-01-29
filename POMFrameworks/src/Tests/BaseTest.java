package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Common.CommonFunctions;
import Common.Config;

public class BaseTest
{
	
	public static ExtentReports report;
	public static ExtentTest logger; 
	public static String extentReport;
	
	public WebDriver driver;
	
	public void createReport()
	{
		report=CommonFunctions.setupResult();		
	}
	
	
	public void launchApp()
	{
		System.out.println("Start Class");
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//utilities//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Config.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Config.defaultTime,TimeUnit.SECONDS);
		
	}
	
	public void CloseApp()
	{
		driver.close(); 
		driver.quit();
	}

}
