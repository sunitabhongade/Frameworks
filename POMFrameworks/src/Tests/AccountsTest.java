package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Common.CommonFunctions;
import Common.Config;
import Pages.AccountsPage;
import Pages.HomePage;
import Pages.LoginPage;

public class AccountsTest extends BaseTest
{
	
	
	@BeforeClass(alwaysRun=true)
	public void TestsStarts()
	{
		launchApp();
		{
			if(report==null)
			{
				createReport();
			}
		}
	}
	@Test(groups = { "regression","smoke","sanity"})
	public void CreateAccounts_TC009() throws Exception
	{
		logger=report.startTest("CreateAccounts_TC009");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login(Config.username, Config.password);
		logger=report.startTest("CreateAccounts_TC009");
		HomePage hp=new HomePage(driver,logger);
		hp.ClickNewAccountLink();
		logger.log(LogStatus.PASS, "Click on New Accounts Link Successfuly");
		AccountsPage ap=new AccountsPage(driver,logger);
		ap.CreateAccountWithMandataryfields("Saving", "wbc");
		CommonFunctions.getscreenshot("CreateAccounts_TC009", driver);
		logger.log(LogStatus.PASS, "NewAccounts created successfully");
		report.endTest(logger);
		report.flush();
		
	}
	@Test(dependsOnMethods={"CreateAccounts_TC009"},groups = { "regression","smoke","sanity"})
	public void ClickOnChangeButton_TC010() throws Exception
	{
		HomePage hp=new HomePage(driver,logger);
		hp.ClickNewAccountLink();
		logger.log(LogStatus.PASS, "Click on New Accounts Link Successfuly");
		AccountsPage ap=new AccountsPage(driver,logger);
		ap.NewAccountClickOnChangeButton("SAP", "UFF");
		CommonFunctions.getscreenshot("ClickOnChangeButton_TC010", driver);
		logger.log(LogStatus.PASS, "Change button Clicked successfully");
		report.endTest(logger);
		report.flush();
	}
	
	@AfterClass(alwaysRun=true)
	public void TierDown()
	{
		CloseApp();
	}
	
}


