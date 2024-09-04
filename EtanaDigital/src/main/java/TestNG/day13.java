package TestNG;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class day13 {
	
	WebDriver driver;
	
//	@BeforeClass
//	void login() {
//	System.out.println("Login functionality is successfully");
//	}
//	
//	@AfterClass
//	void logout() {
//	System.out.println("Logout functionality is successfully");
//	}
//	
//	@Test(priority=1)
//	void search() {
//	System.out.println("Search functionality is successfully");
//	}
//	
//	@Test(priority=2)
//	void Advancesearch() {
//	System.out.println("Advance Search functionality is successfully");
//	}
//	
	
	@Test
	void openurl() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		boolean logcheck = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']//img[1]")).isDisplayed();
		System.out.println(logcheck);
//		boolean logcheck1 = true;
//		Assert.assertEquals(logcheck, logcheck1);
	}
	


}
