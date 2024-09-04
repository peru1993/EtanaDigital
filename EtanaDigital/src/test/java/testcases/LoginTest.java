package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;

	private String expectedUrl = ConfigReader.getPropertyFromKey("url");
	private String ValidEmail = ConfigReader.getPropertyFromKey("ValidEmail");
	private String ValidPassword = ConfigReader.getPropertyFromKey("ValidPassword");
	private String InvalidEmail = ConfigReader.getPropertyFromKey("InvalidEmail");
	private String InvalidPassword = ConfigReader.getPropertyFromKey("InvalidPassword");

	@Test(priority = 1)
	private void verifyloginpagenecessaryfield() {
		printMethodName();
		// Create an instance of the LoginPage
		loginPage = new LoginPage(driver);
		// VerifyUrl
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, expectedUrl, "The current URL does not match the expected URL.");
		// Verify Email Label
		Assert.assertTrue(loginPage.getEmailLabel().isDisplayed(), "Email label is not displayed.");
		// Verify Password Label
		Assert.assertTrue(loginPage.getPasswordLabel().isDisplayed(), "Password label is not displayed.");
		// Verify Login Button
		Assert.assertTrue(loginPage.getLoginButton().isDisplayed(), "Login button is not displayed.");
		// Verify 'Forgot Password' Link
		Assert.assertTrue(loginPage.getForgotPasswordLink().isDisplayed(), "'Forgot Password' link is not displayed.");
	}

	@Test(priority = 2)
	private void verifyLoginWithEmptyCredentials() {
		printMethodName();
		loginPage = new LoginPage(driver).clickLoginButton();
		Assert.assertTrue(loginPage.getEmailPasswordErrorMessage().isDisplayed(),"Email & Password error message is incorrect.");
	}

	@Test(priority = 3)
	private void verifyLoginWithEmptyEmailAndValidPassword() {
		printMethodName();
		loginPage = new LoginPage(driver).enterPassword(ValidPassword).clickLoginButton();
		Assert.assertTrue(loginPage.getEmailErrorMessage().isDisplayed(), "Email error message is incorrect.");
	}

	@Test(priority = 4)
	private void verifyLoginWithValidEmailAndEmptyPassword() {
		printMethodName();
		loginPage = new LoginPage(driver).enterEmail(ValidEmail).clickLoginButton();
		Assert.assertTrue(loginPage.getPasswordErrorMessage().isDisplayed(), "Password error message is incorrect.");
	}

	@Test(priority = 5)
	private void verifyLoginWithValidEmailAndInvalidPassword() {
		printMethodName();
		loginPage = new LoginPage(driver).loginAndVerifyErrorMessage(ValidEmail, InvalidPassword);
	}

	@Test(priority = 6)
	private void verifyLoginWithInValidEmailAndvalidPassword() {
		printMethodName();
		loginPage = new LoginPage(driver).loginAndVerifyErrorMessage(InvalidEmail, ValidPassword);
	}

	@Test(priority = 7)
	private void verifyLoginWithInvalidCredentials() {
		printMethodName();
		loginPage = new LoginPage(driver).loginAndVerifyErrorMessage(InvalidEmail, InvalidPassword);
	}

	@Test(priority = 8)
	private void verifyLoginWithvalidCredentials() {
		printMethodName();
		loginPage = new LoginPage(driver).loginAndVerifyErrorMessage(ValidEmail, ValidPassword);
	}
}
