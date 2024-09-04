package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paralleltesting {
	
WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) {
	switch(br) {
	case "chrome":driver = new ChromeDriver(); break;
	case "edge":driver = new EdgeDriver(); break;
	case "firefox":driver = new FirefoxDriver(); break;
	default: System.out.println("Invalid Browser");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(dataProvider="dp")
	void loginpage(String email, String pwd) {
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@AfterClass
	void closeup() {
	driver.quit();
	}
	
	@DataProvider(name ="dp", indices= {0,4})
	Object[][]logindata(){
		Object data[][]= {
				{"Admin", "admin1234"},
				{"Admine", "admin123"},
				{"Adminer", "admin123df"},
				{"", ""},
				{"Admin", "admin123"},
		};
		return data;
	}
	

}

