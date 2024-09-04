package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.WithdrawalsPage;
import utilities.ConfigReader;

public class AccountTest extends BaseTest {
	private LoginPage loginPage;
	private WithdrawalsPage withdrawalspage;
	private AccountPage accountpage;

	private String validEmail = ConfigReader.getPropertyFromKey("ValidEmail");
	private String validPassword = ConfigReader.getPropertyFromKey("ValidPassword");
	private String webhookURL = ConfigReader.getPropertyFromKey("WebhookURL");
	private String changewebhookurl = ConfigReader.getPropertyFromKey("changewebhookurl");

	@Test(priority = 1)
	private void verifyAccountTextPresence() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		Assert.assertTrue(withdrawalspage.getinvestor().isDisplayed(), "Investor text is not displayed.");

		// find account element
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.getAccountTextElement().isDisplayed(), "Account Menu is not displayed.");
	}

	@Test(priority = 2)
	private void verifyAccountPageElements() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// click Account element in side Menu
		accountpage = new AccountPage(driver);
		accountpage.clickAccountSideMenu().verifyAllAccountPageElements();
	}

	@Test(priority = 3)
	private void verifySaveChangesButotnfunctionaoity() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// click Account element in side Menu
		accountpage = new AccountPage(driver);
		accountpage.clickAccountSideMenu().clickEditInfoButton().enterWebhookURL(webhookURL).clickSaveChangesButton()
				.clickEditInfoButton();
		Assert.assertEquals(accountpage.verifyEmailFieldValue(), webhookURL,
				"Email field value does not match the expected value.");
	}

	@Test(priority = 4)
	private void verifyCancelButtonfunctionality() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// click Account element in side Menu
		accountpage = new AccountPage(driver);
		accountpage.clickAccountSideMenu().clickEditInfoButton().enterWebhookURL(changewebhookurl).clickCancelButton()
				.clickEditInfoButton();
		Assert.assertEquals(accountpage.verifyEmailFieldValue(), webhookURL,
				"Email field value does not match the expected value.");
	}

}
