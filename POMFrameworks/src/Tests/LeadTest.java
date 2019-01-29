package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Common.CommonFunctions;
import Common.Config;
import Pages.CreateLead;
import Pages.HomePage;
import Pages.LoginPage;

public class LeadTest extends BaseTest
{
	
	
	
	@BeforeClass(alwaysRun=true)
	public void TestStarts()
	{
		launchApp();
		if(report==null)
		{
			createReport();
		}
		
	}
	
	@Test(groups = { "regression","smoke","sanity"})
	public void CreateLead_TC005() throws Exception
	{
		logger=report.startTest("CreateLead_TC005");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login(Config.username, Config.password);
		HomePage hp=new HomePage(driver,logger);
		hp.ClickNewLeadLink();
		logger.log(LogStatus.PASS, "Click New Lead Link Successfuly");
		CreateLead cl=new CreateLead(driver,logger); 
		cl.CreateLeadWithMandataryFields("Modi", "BJP");
		CommonFunctions.getscreenshot("CreateLead_TC005", driver);
		logger.log(LogStatus.PASS, "Lead created successfully");
		report.endTest(logger);
		report.flush();
	}
	
	@Test(dependsOnMethods={"CreateLead_TC005"},groups = { "regression","smoke","sanity"})
	public void CreateLeadEdit_TC006() throws Exception
	{
		
		logger.log(LogStatus.PASS, "Lead created successfully");
		CreateLead cl=new CreateLead(driver,logger); 
		cl.CreateLeadClickEditButton("RTU", "SE");
		logger.log(LogStatus.PASS, "Edit Button Clicked successfully");
		Assert.assertEquals(cl.ValidateEditedData(), true);
		logger.log(LogStatus.PASS, "Data Edited successfully");
		CommonFunctions.getscreenshot("CreateLeadEdit_TC006", driver);
		report.endTest(logger);
		report.flush();
	}
	
	
	@Test(dependsOnMethods={"CreateLeadEdit_TC006"},groups = { "regression","smoke","sanity"})
	public void CreateLeadDuplicate_TC007() throws Exception
	{
		logger.log(LogStatus.PASS, "Lead created successfully");
		CreateLead cl=new CreateLead(driver,logger); 
		cl.CreateLeadClickDuplicateButton("RTU", "TestLead");
		logger.log(LogStatus.PASS, "Duplicate Button Clicked successfully");
		CommonFunctions.getscreenshot("CreateLeadDuplicate_TC007", driver);
		report.endTest(logger);
		report.flush();
		
	}
	@Test(dependsOnMethods={"CreateLeadDuplicate_TC007"},groups = { "regression","smoke","sanity"})
	public void CreateLeadDelete_TC008() throws Exception
	{
		logger.log(LogStatus.PASS, "Lead created successfully");
		CreateLead cl=new CreateLead(driver,logger); 
		cl.CreateLeadClickDeleteButton("RTU", "TestLead");
		logger.log(LogStatus.PASS, "Delete Button Clicked successfully");
		CommonFunctions.getscreenshot("CreateLeadDelete_TC008", driver);
		report.endTest(logger);
		report.flush();
		
	}

	@AfterClass(alwaysRun=true)
	public void TierDown()
	{
		CloseApp();
	}
	
}
