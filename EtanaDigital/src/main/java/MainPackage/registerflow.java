package MainPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class registerflow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		
		//Create A Register scenario
		
		driver.get("https://testweb.careerscloud.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[contains(@class,'ant-btn css-f7vrd6')])[1]")).click();
        String registertilte = driver.getTitle();
        System.out.println(registertilte);
        
	}

}
