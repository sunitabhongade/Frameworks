package Pages;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends HeaderPage {
	
	private WebDriver driver;

	public HomePage(WebDriver driver,ExtentTest logger) 
	{
		super(driver,logger);
		this.driver=driver;
		
	}

}
