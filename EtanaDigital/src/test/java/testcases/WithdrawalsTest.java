package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.WithdrawalsPage;
import pageobject.LoginPage;
import utilities.ConfigReader;

public class WithdrawalsTest extends BaseTest {

	private LoginPage loginPage;
	private WithdrawalsPage withdrawalspage;

	private String validEmail = ConfigReader.getPropertyFromKey("ValidEmail");
	private String validPassword = ConfigReader.getPropertyFromKey("ValidPassword");

	@Test(priority = 1)
	public void verifyWithdrawalsSection() {
		printMethodName();

		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);

		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		Assert.assertTrue(withdrawalspage.getinvestor().isDisplayed(), "Investor text is not displayed.");

		// Perform action on the dashboard
		withdrawalspage.clickCSVAndJSONTransactions();
	}

	@Test(priority = 2)
	public void verifyFilterTextAndIcon() {
		printMethodName();
		
		
		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);
		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		// Perform action on the dashboard
		withdrawalspage.clickWithdrawalsButton();
		// Verify that the filter icon & text is present on the page
		Assert.assertTrue(withdrawalspage.getFilterIconElement().isDisplayed(), "Filter Icon is not displayed.");
		Assert.assertTrue(withdrawalspage.getFilterTextElement().isDisplayed(), "Filter Text is not displayed.");
	}
	
	@Test(priority = 3)
	public void verifyFilterAndClearAllButtonStatus() {
		printMethodName();
		
		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);
		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		// Perform action on the dashboard
		withdrawalspage.clickWithdrawalsButton().clickFilterButton().getClearButtonStatus();
		withdrawalspage.verifyAllFilterElements();
	}
	
	@Test(priority = 4)
	public void verifyNetworksFilterFunctionality() {
		printMethodName();
		
		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);
		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		// Perform action on the dashboard
		withdrawalspage.clickWithdrawalsButton().clickFilterButton().getnetWorksBitcoinLocatorTextElement().click();
		withdrawalspage.getClearButtonStatus();
		withdrawalspage.getBitcoinFilteredResults();
	}
	
	@Test(priority = 5)
	public void verifyApprovalStatusFilterFunctionality() {
		printMethodName();
		
		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);
		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		// Perform action on the dashboard
		withdrawalspage.clickWithdrawalsButton().clickFilterButton().getapprovalStatusApprovedLabelLocatorTextElement().click();
		withdrawalspage.getClearButtonStatus();
		withdrawalspage.getApprovedFilteredResults();
	}
	
	
	@Test(priority = 6)
	public void verifySelectAllNetworksFilterFunctionality() {
		printMethodName();
		
		// Login to the application
		loginPage = new LoginPage(driver);
		loginPage.loginAndVerifyErrorMessage(validEmail, validPassword);
		// Navigate to Dashboard and verify elements
		withdrawalspage = new WithdrawalsPage(driver);
		// Perform action on the dashboard
		withdrawalspage.clickWithdrawalsButton().clickFilterButton().selectNetworkscheckbox().getClearButtonStatus();
		System.out.println("fsakdjfkajdf");
	}
	
}
