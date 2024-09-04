package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class LoginPage extends BasePage {
	
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators for login page elements
    public By emailLabelLocator = By.xpath("//label[normalize-space(text())='Email']");
    public By passwordLabelLocator = By.xpath("//label[normalize-space(text())='Password']");
    public By loginButtonLocator = By.xpath("//button[@type='submit']");
    public By forgotPasswordLinkLocator = By.xpath("//div[normalize-space(text())='Forgot Password?']");
    public By emailPasswordErrorMessage = By
            .xpath("//div[normalize-space(text())='Please enter your email and password.']");
    public By loginErrorMessage = By.xpath("//div[normalize-space(text())='Incorrect username or password.']");
    public By emailErrorMessage = By.xpath("//div[normalize-space(text())='Please enter your email.']");
    public By passwordErrorMessage = By.xpath("//div[normalize-space(text())='Please enter your password.']");
    public By emailField = By.xpath("//input[@type='email']");
    public By passwordField = By.xpath("//input[@type='password']");
    public By investor = By.xpath("//div[normalize-space(text())='INVESTOR']");
//    public By homePage = By.xpath("//h1[normalize-space(text())='ETANATRUST']");

    // Page actions

    public LoginPage enterEmail(String Email) {
        SmartWait(2);
        sendKeysElement(emailField, Email, "Email");
        return this;
    }

    public LoginPage enterPassword(String Password) {
        SmartWait(2);
        sendKeysElement(passwordField, Password, "Password");
        return this;
    }

    public LoginPage clickLoginButton() {
        clickElement(loginButtonLocator, "login_click");
        SmartWait(1);
        return this;
    }

    public WebElement getEmailLabel() {
        SmartWait(2);
        return driver.findElement(emailLabelLocator);
    }

    public WebElement getPasswordLabel() {
        SmartWait(2);
        return driver.findElement(passwordLabelLocator);
    }

    public WebElement getLoginButton() {
        SmartWait(2);
        return driver.findElement(loginButtonLocator);
    }

    public WebElement getForgotPasswordLink() {
        SmartWait(2);
        return driver.findElement(forgotPasswordLinkLocator);
    }

    public WebElement getEmailPasswordErrorMessage() {
        SmartWait(2);
        return driver.findElement(emailPasswordErrorMessage);
    }

    public WebElement getEmailErrorMessage() {
        SmartWait(2);
        return driver.findElement(emailErrorMessage);
    }

    public WebElement getPasswordErrorMessage() {
       SmartWait(2);
        return driver.findElement(passwordErrorMessage);
    }

    public WebElement getLoginErrorMessage() {
        SmartWait(2);
        return driver.findElement(loginErrorMessage);
    }

    public WebElement getHomePage() {
        SmartWait(2);
        return driver.findElement(investor);
    }

    public LoginPage loginAndVerifyErrorMessage(String email, String password) {
        if (email != null && password == null) {
            enterEmail(email).clickLoginButton();
            Assert.assertTrue(getPasswordErrorMessage().isDisplayed(), "Password error message is incorrect.");
        } else if (email == null && password != null) {
            enterPassword(password).clickLoginButton();
            Assert.assertTrue(getEmailErrorMessage().isDisplayed(), "Email error message is incorrect.");
        } else if (email != null && password != null) {
            enterEmail(email).enterPassword(password).clickLoginButton();
            try {
                Assert.assertTrue(getLoginErrorMessage().isDisplayed(), "Login error message is incorrect.");
            } catch (Exception e) {
                SmartWait(2);
                Assert.assertTrue(getHomePage().isDisplayed(), "Login failed: Dashboard is not displayed.");
                SmartWait(2);
                Assert.assertEquals(driver.getCurrentUrl(), "https://etanadigital.net/dashboard",
                        "URL after successful login is incorrect.");
            }
        } else {
            throw new IllegalArgumentException("Both email and password cannot be null.");
        }
        return this;
    }

}
