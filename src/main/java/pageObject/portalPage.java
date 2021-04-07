package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalPage {

	public WebDriver driver;
	By SearchBox=By.id("search-courses");
	
	public portalPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getSearchBox()
	{
		return driver.findElement(SearchBox);
	}
	
	
	
	
	
	
}
