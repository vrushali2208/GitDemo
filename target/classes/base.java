package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		//System.getProperty("user.dir") : This gives exact path upto current projects root folder in ay system
		FileInputStream fis = new FileInputStream("C:\\Users\\Pankaj\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pankaj\\chromedriver1.exe");
		driver=new ChromeDriver();
		
		/*if(browserName.contains("chrome"))
		{
			//Execute test cases in chrome browser
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pankaj\\chromedriver1.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);	
			
		}
		 else if(browserName.equals("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pankaj\\geckodriver.exe");
			 driver=new FirefoxDriver();
		 }
		 else if(browserName.equals("IE"))
		 {
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Pankaj\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		 }*/
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(DestinationFile));
		return DestinationFile;
		
	}
}
