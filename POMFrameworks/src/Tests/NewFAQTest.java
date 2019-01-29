package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Common.CommonFunctions;
import Common.Config;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewFAQPage;

public class NewFAQTest extends BaseTest
{
	
	@BeforeClass(alwaysRun=true)
	public void TestStarts()
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
	public void NewFAQClickOnMandatoryFields_TC013() throws Exception
	{
		logger=report.startTest("NewFAQClickOnMandatoryFields_TC013");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login(Config.username, Config.password);
		HomePage hp=new HomePage(driver,logger);
		hp.ClickNewFAQ();
		logger.log(LogStatus.PASS, "Click On NewFAQ Link Successfully");
		NewFAQPage nfaqp=new NewFAQPage(driver,logger);
		nfaqp.ClickNewFAQWithMandatoryFields("How Are You?","I'm Fine");
		CommonFunctions.getscreenshot("NewFAQClickOnMandatoryFields_TC013", driver);
		logger.log(LogStatus.PASS, "Click on NewFAQ Mandatary fields Successfully");
		report.endTest(logger);
		report.flush();
	}
	@Test(dependsOnMethods={"NewFAQClickOnMandatoryFields_TC013"},groups = { "regression","smoke","sanity"})
	public void NewFAQClickOnChangeButton_TC014() throws Exception
	{
		NewFAQPage nfaqp=new NewFAQPage(driver,logger);
		nfaqp.ClickNewFAQChangeButton("Reviewed", "What's Your Status?", "Ongoing", "General");
		CommonFunctions.getscreenshot("NewFAQClickOnChangeButton_TC014", driver);
		logger.log(LogStatus.PASS, "Click on NewFAQ Change Button Successfully");
		report.endTest(logger);
		report.flush();
	}
	
	

}
