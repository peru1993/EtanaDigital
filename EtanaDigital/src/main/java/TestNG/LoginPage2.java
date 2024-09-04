package TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	  	WebDriver driver;
	    //withpagefactory type
		//create a constructor
		LoginPage2(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
//      create locator and element
//		
//		By username = By.xpath("//input[@placeholder='Username']");
//		By password = By.xpath("//input[@placeholder='Password']");
//		By login = By.xpath("//button[normalize-space()='Login']");
		
		@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
		@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
		@FindBy(xpath="//button[normalize-space()='Login']") WebElement login;

		
		//methods or action of the page
		
		public void setUserName(String user) {
			username.sendKeys(user);;
		}
		
		public void setPassword(String pass) {
			password.sendKeys(pass);;
		}
		
		public void login() {
			login.click();
		}
}
