package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class HomePageTest extends base{
	WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialise() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider="getData")
	public <getSignIn> void basePageNavigation(String Username, String Password, String Text) throws IOException, InterruptedException 
	{
		driver.get(prop.getProperty("url"));
		
		landingPage sgnIn = new landingPage(driver);
		sgnIn.getSignIn().click();
		
		loginPage lp = new loginPage(driver);
		lp.userName().sendKeys(Username);
		log.info("Username entered successfully");
		lp.password().sendKeys(Password);
		log.info("Password entered successfully");
		log.info(Text);
		Thread.sleep(3000);
		lp.logInButton().click();	
		
	}
	
	
	
	 @DataProvider
	 
	 public Object[][] getData()
	 {
		 //Rows stands for how many different types of data should run the test
		 //Columns stands for how many values per test 
		 
		 Object[][] data= new Object[2][3];
		 //0th row
		 data[0][0]="Vrushali@gmail.com";
		 data[0][1]="Vrushali";
		 data[0][2]="Restricted User";
		 
		 //1st row
		 data[1][0]="Vrushali1@gmail.com";
		 data[1][1]="Vrushali1";
		 data[1][2]="Non Restricted User";
		 
		 return data;
	 }
	
	 @AfterTest
		public void tearDown()
		{
			driver.close();
		}
	
}
