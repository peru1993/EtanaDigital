package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import pageobject.LogoutPage;
import pageobject.WithdrawalsPage;
import utilities.ConfigReader;

public class LogoutTest extends BaseTest {
	private LoginPage loginPage;
	private WithdrawalsPage withdrawalspage;
	private LogoutPage logoutPage;

	private String validEmail = ConfigReader.getPropertyFromKey("ValidEmail");
	private String validPassword = ConfigReader.getPropertyFromKey("ValidPassword");
	private String expectedUrl = ConfigReader.getPropertyFromKey("homeurl");

	@Test(priority = 1)
	private void verifyLogoutTextPresence() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		Assert.assertTrue(withdrawalspage.getinvestor().isDisplayed(), "Investor text is not displayed.");

		// find Logout element
		logoutPage = new LogoutPage(driver);
		Assert.assertTrue(logoutPage.getLogoutTextElement().isDisplayed(), "Logout text is not displayed.");
	}

	@Test(priority = 2)
	private void verifyLogoutPageElements() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// click Logout element
		logoutPage = new LogoutPage(driver);
		logoutPage.clickLogoutSideMenu();
		logoutPage.verifyAllLogoutPageElements();
	}

	@Test(priority = 3)
	private void verifyGoHomeButtonFunctionality() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// click Logout element
		logoutPage = new LogoutPage(driver);
		logoutPage.clickLogoutSideMenu();
		logoutPage.clickgoHomeButton();

		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		Assert.assertTrue(withdrawalspage.getinvestor().isDisplayed(), "Investor text is not displayed.");
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The current URL does not match the expected URL.");
	}

	@Test(priority = 4)
	private void verifyFinalLogoutAction() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// click Logout element and click LogoutButton
		logoutPage = new LogoutPage(driver);
		logoutPage.clickLogoutSideMenu();
		logoutPage.clickLogoutButton();

		// Verify Email Label
		Assert.assertTrue(loginPage.getEmailLabel().isDisplayed(), "Email label is not displayed.");
		// Verify Password Label
		Assert.assertTrue(loginPage.getPasswordLabel().isDisplayed(), "Password label is not displayed.");
		// Verify Login Button
		Assert.assertTrue(loginPage.getLoginButton().isDisplayed(), "Login button is not displayed.");
		// Verify 'Forgot Password' Link
		Assert.assertTrue(loginPage.getForgotPasswordLink().isDisplayed(), "'Forgot Password' link is not displayed.");

	}

}
