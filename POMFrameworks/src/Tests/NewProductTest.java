package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Common.CommonFunctions;
import Common.Config;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewProductPage;

public class NewProductTest extends BaseTest
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
	public void ClickOnNewProduct_TC015() throws Exception
	{
		logger=report.startTest("ClickOnNewProduct_TC015");
		LoginPage lp=new LoginPage(driver,logger);
		lp.Login(Config.username, Config.password);
		HomePage hp=new HomePage(driver,logger);
		hp.ClickNewProduct();
		logger.log(LogStatus.PASS, "Click On NewProduct Link Successfully");
		NewProductPage npp=new NewProductPage(driver,logger);
		npp.ClickOnNewProduct("WBC", "AltvetPet Inc.", "UDB");
		CommonFunctions.getscreenshot("NewFAQClickOnMandatoryFields_TC013", driver);
		logger.log(LogStatus.PASS, "Click on NewFAQ Mandatary fields Successfully");
		report.endTest(logger);
		report.flush();

	}

}
