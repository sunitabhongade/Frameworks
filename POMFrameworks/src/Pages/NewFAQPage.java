package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class NewFAQPage extends HeaderPage 
{
	private WebDriver driver;
	

	public NewFAQPage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);
		this.driver=driver;
		
	}
	By tb_question=By.name("question");
	By tb_answer=By.name("faq_answer");
	By drp_status=By.name("faqstatus");
	By drp_catagory=By.name("faqcategories");
	By btn_save=By.name("button");
	By btn_change=By.name("button");
	By btn_duplicate=By.name("Duplicate");
	By lnk_newPurchaceOrder=By.linkText("New Purchase Order");
	By lnk_myAccount=By.linkText("My Account");
	By btn_customise=By.name("Customise");
	By btn_Save=By.xpath("(//input[@value='Save'])[1]");
	By btn_Source1=By.id("cl8");
	By btn_Target1=By.id("cl4");
	
	public void ClickNewFAQWithMandatoryFields(String str_que,String str_ans)
	{
		driver.findElement(tb_question).sendKeys(str_que);
		driver.findElement(tb_answer).sendKeys(str_ans);
		driver.findElements(btn_save).get(0).click();
	}
	
	public void ClickNewFAQChangeButton(String str_status,String str_que,String str_ans,String str_catagory)
	{
		driver.findElements(btn_duplicate).get(0).click();
		driver.findElements(btn_change).get(2).click();
		Set<String> set=driver.getWindowHandles();
		Iterator<String> iter=set.iterator();
		String FirstWindow=iter.next();
		System.out.println(FirstWindow);
		String SecondWindow=iter.next();
		System.out.println(SecondWindow);
		driver.switchTo().window(SecondWindow);
		driver.findElement(By.linkText("Vtiger Single User Pack")).click();
		driver.switchTo().window(FirstWindow);
		Select drpStatus=new Select(driver.findElement(drp_status));
		drpStatus.selectByValue(str_status);
		driver.findElement(tb_question).clear();
		driver.findElement(tb_question).sendKeys(str_que);
		driver.findElement(tb_answer).clear();
		driver.findElement(tb_answer).sendKeys(str_ans);
		Select drpCatagory=new Select(driver.findElement(drp_catagory));
		drpCatagory.selectByValue(str_catagory);
		driver.findElements(btn_save).get(0).click();
	}
	
	

}
