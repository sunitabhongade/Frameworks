package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

public class NewProductPage extends HeaderPage
{
	private WebDriver driver;

	public NewProductPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
		this.driver=driver;
		
	}
	
	By tb_productname=By.name("productname");
	By drp_manufacturer=By.name("manufacturer");
	By btn_change=By.xpath("//input[@value='Change'][1]");
	By tb_productcode=By.name("productcode");
	By btn_save=By.name("button");
	
	
	public void ClickOnNewProduct(String str_product,String str_manufa,String str_productcode) throws InterruptedException
	{
		driver.findElement(tb_productname).sendKeys(str_product);
		Select drpManufac=new Select(driver.findElement(drp_manufacturer));
		drpManufac.selectByValue(str_manufa);
		driver.findElement(btn_change).click();
		Set<String> set=driver.getWindowHandles();
		Iterator<String> iter=set.iterator();
		String FirstWindow=iter.next();
		System.out.println(FirstWindow);
		String SecondWindow=iter.next();
		System.out.println(SecondWindow);
		driver.switchTo().window(SecondWindow);
		driver.findElement(By.linkText("Mary Smith")).click();
		driver.switchTo().window(FirstWindow);
		driver.findElement(tb_productcode).sendKeys(str_productcode);
		//driver.findElement(By.name("imagename")).sendKeys("F:\\Photos\\Lavasa.jpg");
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys("F:\\Photos\\Lonavala.jpg");
		//Thread.sleep(5000);
		//driver.findElements(btn_save).get(0).click();

	}

}
