package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	By logoutTextLocator = By.xpath("//span[normalize-space(text())='Logout']");
	By logoutButtonLocator = By.xpath("//button[normalize-space(text())='Logout']");
	By goHomeButtonLocator = By.xpath("//button[normalize-space(text())='Go Home']");
	By logoutPromptQuestionLocator = By.xpath("//h1[normalize-space(text())='Are you sure you want to logout?']");
	By homeButtonLocator = By.xpath("//button[@type='button'][1]");
	By investorTextLocator = By.xpath("//div[normalize-space(text())='INVESTOR']");

	public WebElement getLogoutTextElement() {
		return driver.findElement(logoutTextLocator);
	}

	public WebElement getLogoutButtonElement() {
		return driver.findElement(logoutButtonLocator);
	}

	public WebElement getgoHomeButtonElement() {
		return driver.findElement(goHomeButtonLocator);
	}

	public WebElement getlogoutPromptQuestionElement() {
		return driver.findElement(logoutPromptQuestionLocator);
	}
	
	public LogoutPage clickLogoutSideMenu() {
		clickElement(logoutTextLocator, "sidemenulogout_click");
		return this;
	}

	public LogoutPage clickLogoutButton() {
		clickElement(logoutButtonLocator, "logout_click");
		return this;
	}

	public LogoutPage clickgoHomeButton() {
		clickElement(goHomeButtonLocator, "goHome_click");
		return this;
	}
	
	public void verifyAllLogoutPageElements() {
		Assert.assertTrue(getLogoutButtonElement().isDisplayed(), "Logout Button is not displayed.");
		Assert.assertTrue(getgoHomeButtonElement().isDisplayed(), "GoHome Button is not displayed.");
		Assert.assertTrue(getlogoutPromptQuestionElement().isDisplayed(), "GoHome Button is not displayed.");
	}

}
