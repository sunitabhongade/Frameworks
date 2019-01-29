package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class NewTicketPage extends HeaderPage 
{ 
	private WebDriver driver;

	public NewTicketPage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);
		this.driver=driver;
	
	}
	
	By btn_assignedTo=By.xpath("//input[@type='radio'][@name='assigntype']");
	By drpbtn_priority=By.name("ticketpriorities");
	By drpbtn_severity=By.name("ticketseverities");
	By drpbtn_catagory=By.name("ticketcategories");
	By tb_title=By.name("ticket_title");
	By btn_save=By.name("button");
	By btn_edit=By.name("Edit");
	
	public void NewTicketEnterData(String Str_Priority, String Str_Severity, String Str_Category, String Str_Title )
	{
		driver.findElement(btn_assignedTo).click();
		
		Select drpPriority=new Select(driver.findElement(drpbtn_priority));
		drpPriority.selectByValue(Str_Priority);
		Select drpseverity=new Select(driver.findElement(drpbtn_severity));
		drpseverity.selectByValue(Str_Severity);
		Select drpCategory=new Select(driver.findElement(drpbtn_catagory));
		drpCategory.selectByValue(Str_Category);
		driver.findElement(tb_title).sendKeys(Str_Title);
		driver.findElements(btn_save).get(0).click();
		
	}
	
	public void NewTicketEditButton(String Str_Title)
	{
		driver.findElements(btn_edit).get(0).click();
		driver.findElement(tb_title).clear();
		driver.findElement(tb_title).sendKeys(Str_Title);
		driver.findElements(btn_save).get(0).click();
	}

}
