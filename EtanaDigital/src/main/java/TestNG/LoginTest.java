package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
		void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		}

	@Test
	void logitest() {
	LoginPage2 lg = new LoginPage2 (driver);
	lg.setUserName("Admin");
	lg.setPassword("admin123");
	lg.login();
	Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void quit() {
		driver.quit();
	}
}
