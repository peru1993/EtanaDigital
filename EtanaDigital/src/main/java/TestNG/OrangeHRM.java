package TestNG;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	void basesetup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);	
	}
	
	@Test(priority=1)
	void testlogo() { 	
		boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']//img[1]")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	void testurltitle() { 
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=3, dependsOnMethods= {"testurltitle"})
	void testurl() { 
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	

	@AfterClass
	void quit() {
		driver.quit();
	}
	
}
