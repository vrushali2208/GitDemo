package StepDefinations;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;

//import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObject.landingPage;
import pageObject.loginPage;
import pageObject.portalPage;
import resources.base;

@RunWith(Cucumber.class)

public class stepDefination extends base {

	@Given("Initialise the browser with chrome")
	public void initialise_the_browser_with_chrome() throws IOException {
		driver=initializeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
		driver.get(string);
 
		
	}
	
	@Given("click on login link of home to in order to land on sign in page")
	public void click_on_login_link_of_home_to_in_order_to_land_on_sign_in_page() {
		landingPage sgnIn = new landingPage(driver);
		sgnIn.getSignIn().click();
		
	}
	
	@When("User enters {string} and {string} and logs in")
	public void user_enters_and_and_logs_in(String string, String string2) {
		loginPage lp = new loginPage(driver);
		lp.userName().sendKeys(string);
		lp.password().sendKeys(string2);
		lp.logInButton().click();
	}
	
	@Then("verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
		portalPage pp= new portalPage(driver);
		Assert.assertTrue(pp.getSearchBox().isDisplayed());	  
		//System.out.println(pp.getSearchBox().isDisplayed());
		
	} 

} 
