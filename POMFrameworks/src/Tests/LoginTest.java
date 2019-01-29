package Tests;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common.CommonFunctions;
import Common.Config;
import Pages.HomePage;
import Pages.LoginPage;



//@Listeners(Tests.TestNGListener.class)
public class LoginTest extends BaseTest 
{
	
	@BeforeClass(alwaysRun=true)
	public void TestsStart()
	{
		launchApp();
		if(report==null)
		{
			createReport();
		}
		
	}
	
	@Test(groups={"sanity"})
	public void verifyAppUrl()
	{
		logger=report.startTest("verifiAppUrl_TC001");
		LoginPage lp=new LoginPage(driver,logger);
		Assert.assertEquals(lp.ValidateLoginPageTitle(),true);
		logger.log(LogStatus.PASS, "Title matched successfully");
		report.endTest(logger);
		report.flush();
		
	}
	
	@Test(groups = { "smoke"})
	public void verifyAppLogo()
	{
		logger=report.startTest("verifyAppLogo_TC02");
		LoginPage lp=new LoginPage(driver,logger);		
		Assert.assertEquals(lp.ValidateLoginLogo(), "Success");
		logger.log(LogStatus.PASS, "Logo displyed successfully");
		report.endTest(logger);
		report.flush();
		
	}
	
	@Test(dataProvider = "dp",groups = { "regression"})
	public void InValidLogin(String user,String pwd) throws Exception
	{
		logger=report.startTest("InvalidLogin_TC03");
		LoginPage lp=new LoginPage(driver,logger);	
		lp.Login(user, pwd);
		Assert.assertEquals(lp.ValidateLoginErrorMsg(), "Success");
		logger.log(LogStatus.PASS, "Invalid login test executed successfully");
		report.endTest(logger);
		report.flush();
	}
	
	@Test(dataProvider = "ValidData",dependsOnMethods={"verifyAppLogo"},groups = { "regression","smoke","sanity"})
	public void ValidLogin(String user,String pwd) throws Exception
	{
		logger=report.startTest("validLogin_TC04");
		LoginPage lp=new LoginPage(driver,logger);	
		lp.Login(user, pwd);
		HomePage hp=new HomePage(driver,logger);		
		Assert.assertEquals(hp.VerifyLogoutLink(), true);
		logger.log(LogStatus.PASS, "Valid login test executed successfully");
		report.endTest(logger);
		report.flush();
	}
	
		
	
	@AfterClass(alwaysRun=true)
	public void TierDown()
	{
		CloseApp();
	}
	
	
	@DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "test1", "Test1" },
	      new Object[] { "test2", "Test2" },
	      new Object[] { "test3", "Test3" },
	    };
	  }
	
	@DataProvider
	  public Object[][] ValidData() {
	    return new Object[][] {
	      new Object[] { Config.username,Config.password },
	      
	    };
	  }

}
