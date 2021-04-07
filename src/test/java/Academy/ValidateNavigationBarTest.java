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


import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class ValidateNavigationBarTest extends base{
	WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public <getSignIn> void validateNavigationBar() throws IOException, InterruptedException 
	{
				
		landingPage sgnIn = new landingPage(driver);		
		Assert.assertTrue(sgnIn.getNaviBar().isDisplayed());
		log.info("Navigation Bar is displayed");

		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
		
}
