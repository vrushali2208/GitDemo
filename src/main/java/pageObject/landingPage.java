package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;
	//Here below by making data/variable 'private' and their access methods 'public' we are achieving 'Encapsulation'
	private By SignIn=By.cssSelector("a[href*='sign_in']");
	private By Title=By.cssSelector(".text-center h2");
	private By NavigationBar=By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	//Public methods which are accessing private variables
	public WebElement getSignIn()
	{
		return driver.findElement(SignIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	public WebElement getNaviBar()
	{
		return driver.findElement(NavigationBar);
	}
	
	
}
