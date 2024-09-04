package MainPackage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class day1 {

	public static void main(String[] args) throws InterruptedException {
	
		// TODO Auto-generated method stub
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
//		WebDriver driver = new ChromeDriver();
		//open Url
		driver.get("https://testweb.careerscloud.in/");
		//maximize window
		driver.manage().window().maximize();
		//validate your webpage titile
		String webtitle = driver.getTitle();
		//apply wait
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		if(webtitle.equals("CareersCloud")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
		Thread.sleep(5000);
		//Find the Elements in username and password in login Page
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/button")).click();
		Object[] windowHandles=driver.getWindowHandles().toArray();
	    driver.switchTo().window((String) windowHandles[1]);
	    driver.findElement(By.id("identifierId")).sendKeys("peru.caliaperumal@twilightsoftwares.com");
	    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
	    driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Ashwin@753159852");
	    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
	    driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[3]/div/div/div[2]/div/div/button")).click();
	    driver.switchTo().window((String) windowHandles[0]);
	    String newtitle = driver.getTitle();
	    System.out.println(newtitle);
	    String homefeedurl = driver.getCurrentUrl();
	    System.out.println(homefeedurl);
	    
	    
	    
	    // Locate toast message element based on explicit wait condiction
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"1\"]/div[1]/div")));

        // Verify the toast message text
        String toastText = toastMessage.getText();
        if (toastText.equals("Logged In Successfully !")) {
            System.out.println("Toast Log IN message verified successfully!");
        } else {
            System.out.println("Toast message verification failed.");
        }
        Thread.sleep(8000);
        
        //find selectPreference locator then click bank and insurance value in dropdown.
	    WebElement dropdown = driver.findElement(By.xpath("//div[@name='selectedPreference']"));
        dropdown.click();
        //new code
//        Actions actions = new Actions(driver);
//        WebElement hoverElement = 
        driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[2]")).click();
//        actions.moveToElement(hoverElement).click().build().perform();
//        hoverElement.click();
        
        //find logo dropdown
        WebElement logdropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div[1]/div/div[3]/div/span[3]/span"));
        logdropdown.click();
        //click logout option in dropdown
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[6]")).click();
//        Thread.sleep(3000);
        //click yes in logout dialog box
        WebElement sampletext = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/button[1]"));
        sampletext.click();
     
        //handle logout validation error message
        WebElement logoutmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Logged out successfully ')]")));
    
        // Verify the toast message text
        String checklogoutmessage = logoutmessage.getText();
        if (checklogoutmessage.equals("Logged out successfully")) {
            System.out.println("Toast Logout message verified successfully!");
        } else {
            System.out.println("Toast Logout message verification failed.");
        }
        
       
        
        
      //*[@id="root"]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/button

        
        
	    
//	    Thread.sleep(5000);
//	    Object[] windowHandles1=driver.getWindowHandles().toArray();
//	    driver.switchTo().window((String) windowHandles1[2]);
//	    Thread.sleep(5000);
	    
//	    String homefeedurl = driver.getCurrentUrl();
//	    System.out.println(homefeedurl);
	    
	    

//		//submit the button
//		driver.findElement(By.id("login-button")).click();
//		Thread.sleep(5000);
//		driver.navigate().back();
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//		//close the entire browser.
//		Thread.sleep(5000);
//		driver.quit();

	}

	
	}

