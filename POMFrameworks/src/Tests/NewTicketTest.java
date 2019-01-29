package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.CommonFunctions;
import Common.Config;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewTicketPage;

import com.relevantcodes.extentreports.LogStatus;

public class NewTicketTest extends BaseTest 
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
	public void ClickOnNewTicket_TC011() throws Exception
	{
		logger=report.startTest("ClickOnNewTicket_TC011");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login(Config.username, Config.password);
		HomePage hp=new HomePage(driver,logger);
		hp.ClickNewTicket();
		logger.log(LogStatus.PASS, "Click on New Ticket Link Successfuly");
		NewTicketPage np=new NewTicketPage(driver,logger);
		np.NewTicketEnterData("Normal", "Major", "Small Problem", "You did greate");
		CommonFunctions.getscreenshot("ClickOnNewTicket_TC011", driver);
		logger.log(LogStatus.PASS, "NewTicket created successfully");
		report.endTest(logger);
		report.flush();
	}
	@Test(dependsOnMethods={"ClickOnNewTicket_TC011"},groups = { "regression","smoke","sanity"})
	public void NewTicketClickOnEdit_TC012() throws Exception
	{
		
		logger.log(LogStatus.PASS, "Click Editbutton on New Ticket Link Successfuly");
		NewTicketPage np=new NewTicketPage(driver,logger);
		np.NewTicketEditButton("you did great,appreatiated");
		CommonFunctions.getscreenshot("NewTicketClickOnEdit_TC012", driver);
		logger.log(LogStatus.PASS, "NewTicket created successfully");
		report.endTest(logger);
		report.flush();
		
	}

}
