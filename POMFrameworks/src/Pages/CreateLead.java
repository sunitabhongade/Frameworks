package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

public class CreateLead extends HeaderPage 
{
	private WebDriver driver;

	public CreateLead(WebDriver driver,ExtentTest logger) 
	{
		super(driver,logger);
		this.driver=driver;
		
	}
	String Deletemsg;
	By tb_lastname=By.name("lastname");
	By tb_company=By.name("company");
	By btn_save=By.name("button");
	By btn_edit=By.name("Edit");
	By tb_designetion=By.name("designation");
	By btn_duplicate=By.name("Duplicate");
	By btn_Delete=By.name("Delete");
	
	
	
	public void CreateLeadWithMandataryFields(String lname,String comp)
	{
		driver.findElement(tb_lastname).sendKeys(lname);
		driver.findElement(tb_company).sendKeys(comp);
		driver.findElements(btn_save).get(0).click();
	}
	
	
	
	public void CreateLeadClickEditButton(String comp,String desig)
	{
		driver.findElements(btn_edit).get(0).click();
		driver.findElement(tb_company).clear();
		driver.findElement(tb_company).sendKeys(comp);
		driver.findElement(tb_designetion).sendKeys(desig);
		driver.findElements(btn_save).get(0).click();
		
	}
	
	
	public boolean ValidateEditedData()
	{
		try
		{
			driver.findElement(btn_duplicate).isDisplayed();
		    return true;
		}
		catch(Throwable t)
		{
			
			return false;
		}
		
	}
	
	public void CreateLeadClickDuplicateButton(String comp,String desig)
	{
		driver.findElements(btn_duplicate).get(0).click();
		driver.findElement(tb_designetion).clear();
		driver.findElement(tb_designetion).sendKeys(desig);
		driver.findElements(btn_save).get(0).click();
	}
	
	
	public void CreateLeadClickDeleteButton(String comp,String desig) 
	{
		
		driver.findElements(btn_Delete).get(0).click();
		Alert alt=driver.switchTo().alert();
	    Deletemsg=alt.getText();
	    alt.dismiss();
	    System.out.println(Deletemsg);
	
	}

}


