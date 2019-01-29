package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

    public class LoginPage {
	
  	private WebDriver driver;
  	
    private static ExtentTest logger;	
	
    public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	
	By tb_username=By.name("user_name");
	By tb_userpassword=By.name("user_password");
	By btn_Login=By.name("Login");
	By txt_LoginErrorMsg=By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	By imgLogo=By.xpath("//img[@src='include/images/vtiger-crm.gif']");

			
			
			
			
	public void Login(String user,String pwd)
	{
		driver.findElement(tb_username).clear();
		logger.log(LogStatus.PASS, "TextBox cleared");
		driver.findElement(tb_username).sendKeys(user);
		logger.log(LogStatus.PASS, "Text <b>"+user+ "</b> entered successfully within username field");
		driver.findElement(tb_userpassword).clear();
		logger.log(LogStatus.PASS, "TextBox passwrd Cleared");
		driver.findElement(tb_userpassword).sendKeys(pwd);
		logger.log(LogStatus.PASS, "Text <b>"+pwd+ "</b> entered successfully within username field");
		driver.findElement(btn_Login).click();
		logger.log(LogStatus.PASS, "Login Button Clicked Successfully");
	}
	
	
	public String ValidateLoginLogo()
	{
		try
		{
			boolean msg=driver.findElement(imgLogo).isDisplayed();
			return "Success";
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			return t.getMessage();
		}
	}
	
	public boolean ValidateLoginPageTitle()
	{
		String ActualTitle=driver.getTitle().trim();
		System.out.println("Actual Text:"+ActualTitle);
		if(ActualTitle.equals("vtiger CRM - Commercial Open Source CRM"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public String ValidateLoginErrorMsg()
	{
		try
		{
			boolean msg=driver.findElement(txt_LoginErrorMsg).isDisplayed();
			return "Success";
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			return t.getMessage();
		}
	}
		
			
}
