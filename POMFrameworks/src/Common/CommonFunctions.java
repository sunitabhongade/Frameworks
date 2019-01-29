package Common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;


import com.relevantcodes.extentreports.ExtentReports;

public class CommonFunctions
{
	public static ExtentReports setupResult()
	{
		DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		String Datestr=format.format(date);
		String extentReport=System.getProperty("user.dir")+"\\src\\Report\\vtigerEntentReport"+Datestr+".html";
		System.out.println(extentReport);
		ExtentReports report=new ExtentReports(extentReport);
		return report;
		
	}
	
	 public static void getscreenshot(String testname,WebDriver driver) throws Exception 
     {
		    DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
			Date date=new Date();
			String datestr=format.format(date);
			String filename=System.getProperty("user.dir")+"\\src\\Report\\screenshot\\"+testname+"_"+datestr+".png";
		 
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(filename));
     }


}
