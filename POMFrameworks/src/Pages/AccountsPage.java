package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class AccountsPage extends HeaderPage 
{
	
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver=driver;
		
	}
	
	By tb_accountname=By.name("accountname");
	By tb_website=By.name("website");
	By btn_save=By.name("button");
	//By btn_change=By.xpath("(//input[@type='Change'])");
	By btn_change=By.name("btn1");


	
	public void CreateAccountWithMandataryfields(String acco,String web)
	{
		driver.findElement(tb_accountname).sendKeys(acco);
		driver.findElement(tb_website).sendKeys(web);
		driver.findElements(btn_save).get(0).click();
	}
	
	public void NewAccountClickOnChangeButton(String acco,String web)
	{
		driver.findElement(tb_accountname).clear();
		driver.findElement(tb_accountname).sendKeys(acco);
		driver.findElement(btn_change).click();
		Set<String> set=driver.getWindowHandles();
		Iterator<String> iter=set.iterator();
		String FirstWindow=iter.next();
		System.out.println(FirstWindow);
		String SecondWindow=iter.next();
		System.out.println(SecondWindow);
		driver.switchTo().window(SecondWindow);
		driver.findElement(By.linkText("vtiger")).click();
		driver.switchTo().window(FirstWindow);
		driver.findElement(tb_website).clear();
		driver.findElement(tb_website).sendKeys(web);
		driver.findElements(btn_save).get(0).click();
		
		
	}

}

