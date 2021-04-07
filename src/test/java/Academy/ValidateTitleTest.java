package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;


import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class ValidateTitleTest extends base{
	WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Url got hitted and navigated to Home Page");
		driver.manage().window().maximize();
		log.info("Browser window got Maximized");

	}

	@Test
	public <getSignIn> void validateTitleText() throws IOException, InterruptedException 
	{
				
		landingPage sgnIn = new landingPage(driver);		
		//Compare the browser text with actual text. If not maches then show error
		Assert.assertEquals(sgnIn.getTitle().getText(), "FEATURED COURSES123");
		log.info("Succefully grabbed the Expected Text");

		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
		
}
