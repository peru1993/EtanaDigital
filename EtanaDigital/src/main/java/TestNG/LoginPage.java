package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    
	//create a constructor
	LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// create locator and element
	
	By username = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By login = By.xpath("//button[normalize-space()='Login']");
		
	//methods or action of the page
	
	public void setUserName(String user) {
		driver.findElement(username).sendKeys(user);;
	}
	
	public void setPassword(String pass) {
		driver.findElement(password).sendKeys(pass);;
	}
	
	public void login() {
		driver.findElement(login).click();
	}
	
}
