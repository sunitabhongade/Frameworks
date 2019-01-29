package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class HeaderPage
{
	
	private WebDriver driver;
	
	private static ExtentTest logger;
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	
	By lnk_Logout=By.linkText("Logout");
	By lnk_CreateLead=By.linkText("New Lead");
	By lnk_CreateAccount=By.linkText("New Account");
	By lnk_NewTicket=By.linkText("New Ticket");
	By lnk_NewFAQ=By.linkText("New FAQ");
	By lnk_NewProduct=By.linkText("New Product");
	
	public boolean VerifyLogoutLink()
	{
		if(driver.findElement(lnk_Logout).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ClickNewLeadLink()
	{
		driver.findElement(lnk_CreateLead).click();
	}
	
	public void ClickNewAccountLink()
	{
		driver.findElement(lnk_CreateAccount).click();
	}
	
	public void ClickNewTicket()
	{
		driver.findElement(lnk_NewTicket).click();
	}
	
	public void ClickNewFAQ()
	{
		driver.findElement(lnk_NewFAQ).click();
	}
	
	public void ClickNewProduct()
	{
		driver.findElement(lnk_NewProduct).click();
	}

}
