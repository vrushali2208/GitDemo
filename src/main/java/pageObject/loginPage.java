package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	By Email=By.id("user_email");
	By Password = By.id("user_password");
	By LoginButton= By.xpath("//input[@type='submit']");
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement userName()
	{
		return driver.findElement(Email);
	}
	
	public WebElement password()
	{
		return driver.findElement(Password);
	}
	
	public WebElement logInButton()
	{
		return driver.findElement(LoginButton);
	}
	
	
	
	
}
