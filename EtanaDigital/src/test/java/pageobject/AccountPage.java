package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	

	// Locators for Account page elements
	By accountTextLocator = By.xpath("//button[contains(.,'Account')]"); 
	By myAccountTextLocator = By.xpath("//h1[normalize-space(text())='My Account']");
	By editInfoButtonLocator = By.xpath("//button[contains(.,'Edit Info')]");
	By SubTextLocator = By.xpath("//div[normalize-space(text())='Sub']");
	By firstnameTextLocator = By.xpath("//div[normalize-space(text())='First Name']");
	By lastnameTextLocator = By.xpath("//div[normalize-space(text())='Last Name']");
	By emailTextLocator = By.xpath("//div[normalize-space(text())='Email']");
	By webhookURLTextLocator = By.xpath("//span[normalize-space(text())='Webhook URL']");
	By webhookURLiconLocator = By.xpath("(//span[text()='Webhook URL']/following-sibling::div)[1]");
	By webhookURLiconTextLocator = By.xpath(
			"//div[normalize-space(text())='Notifications about transactions can be sent as HTTP requests to a given URL.']");
	By webhookKeyTextLocator = By.xpath("//span[normalize-space(text())='Webhook Key']");
	By webhookKeyiconLocator = By.xpath("(//span[text()='Webhook Key']/following-sibling::div)[1]");
	By webhookKeyiconTextLocator = By
			.xpath("//div[normalize-space(text())='Use this 32-byte key to decode webhooks with AES.']");
	By apiKeyiconLocator = By.xpath("(//span[text()='API Key']/following-sibling::div)[1]");
	By apiKeyTextLocator = By.xpath("//span[normalize-space(text())='API Key']");
	By verifiedTextLocator = By.xpath("//span[normalize-space(text())='Verified']");
	By webhooKeyShowHideLocator = By.xpath(
			"//div[contains(@class, 'text-gray-400') and contains(@class, 'hover:text-blue-300') and contains(@class, 'cursor-pointer') and contains(@class, 'text-xs') and normalize-space(text())='Show']");
	By saveChangesButtonLocator = By.xpath("//button[contains(.,'Save Changes')]");
	By cancelButtonLocator = By.xpath("//button[contains(.,'Cancel')]");
	By webhookURLFieldLocator = By.xpath("//input[@placeholder='Enter your webhook URL']");
	By webhookURLEditLocator = By.xpath("//div[@class='text-gray-300']/following-sibling::div[1]");

	// Action code
	// Find Elements Code

	public WebElement getAccountTextElement() {
		return driver.findElement(accountTextLocator);
	}

	public WebElement getMyAccountTextElement() {
		return driver.findElement(myAccountTextLocator);
	}

	public WebElement getEditInfoButtonElement() {
		return driver.findElement(editInfoButtonLocator);
	}

	public WebElement getSubTextElement() {
		return driver.findElement(SubTextLocator);
	}

	public WebElement getfirstnameTextElement() {
		return driver.findElement(firstnameTextLocator);
	}

	public WebElement getlastnameTextElement() {
		return driver.findElement(lastnameTextLocator);
	}

	public WebElement getemailTextElement() {
		return driver.findElement(emailTextLocator);
	}

	public WebElement getWebhookURLTextElement() {
		return driver.findElement(webhookURLTextLocator);
	}

	public WebElement getWebhookURLFieldValueElement() {
		return driver.findElement(webhookURLFieldLocator);
	}

	public WebElement getWebhookKeyTextElement() {
		return driver.findElement(webhookKeyTextLocator);
	}

	public WebElement getAPIKeyTextElement() {
		return driver.findElement(apiKeyTextLocator);
	}

	public WebElement getVerifiedTextElement() {
		return driver.findElement(verifiedTextLocator);
	}

	// hover code for webhook URL and Key

	public void testWebHookURLIconHoverText() {

		// Retrieve WebElement
		WebElement svgElement = driver.findElement(webhookURLiconLocator);

		// Perform mouse hover action on the SVG element
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();

		// Locate the text element that appears after hover
		WebElement hoverTextElement = driver.findElement(webhookURLiconTextLocator);

		// Assert the text content
		String expectedText = "Notifications about transactions can be sent as HTTP requests to a given URL.";
		String actualText = hoverTextElement.getText();
		Assert.assertEquals(actualText, expectedText, "Hover text does not match the expected value.");
	}

	public void testWebHookKeyIconHoverText() {

		// Retrieve WebElement
		WebElement svgElement = driver.findElement(webhookKeyiconLocator);

		// Perform mouse hover action on the SVG element
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();

		// Locate the text element that appears after hover
		WebElement hoverTextElement = driver.findElement(webhookKeyiconTextLocator);

		// Assert the text content
		String expectedText = "Use this 32-byte key to decode webhooks with AES.";
		String actualText = hoverTextElement.getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText, "Hover text does not match the expected value.");
	}

	public void testWebHookURLKeyIconHoverText() {
		testWebHookURLIconHoverText();
//		testWebHookKeyIconHoverText();
	}

	// click action code

	public AccountPage clickAccountSideMenu() {
		clickElement(accountTextLocator, "sidemenuAccount_click");
		return this;
	}

	public AccountPage clickEditInfoButton() {
		clickElement(editInfoButtonLocator, "EditInfoButton_click");
		return this;
	}

	public AccountPage clickSaveChangesButton() {
		clickElement(saveChangesButtonLocator, "SaveChangesButton_click");
		return this;
	}

	public AccountPage enterWebhookURL(String WebhookURL) {
		textfieldclear(webhookURLFieldLocator, "webhookURLClear");
		sendKeysElement(webhookURLFieldLocator, WebhookURL, "WebhookURL");
		return this;
	}
	
	public AccountPage clickCancelButton() {
		clickElement(cancelButtonLocator, "CancelButton_click");
		driver.navigate().refresh();
		return this;
	}
	

	// Main assert function of the page.
	public void verifyAllAccountPageElements() {
		
		Assert.assertTrue(getAccountTextElement().isDisplayed(), "Account Menu Button is not displayed.");
		Assert.assertTrue(getMyAccountTextElement().isDisplayed(), "MyAccount Text is not displayed.");
		Assert.assertTrue(getEditInfoButtonElement().isDisplayed(), "EditInfo Button is not displayed.");
		Assert.assertTrue(getSubTextElement().isDisplayed(), "SubText is not displayed.");
		Assert.assertTrue(getfirstnameTextElement().isDisplayed(), "FirstName Text is not displayed.");
		Assert.assertTrue(getlastnameTextElement().isDisplayed(), "LastName Text is not displayed.");
		Assert.assertTrue(getemailTextElement().isDisplayed(), "Email Text is not displayed.");
		Assert.assertTrue(getWebhookURLTextElement().isDisplayed(), "WebHookURL Text is not displayed.");
		Assert.assertTrue(getWebhookKeyTextElement().isDisplayed(), "WebHookKey Text is not displayed.");
		Assert.assertTrue(getAPIKeyTextElement().isDisplayed(), "API Key Text is not displayed.");
		Assert.assertTrue(getVerifiedTextElement().isDisplayed(), "Verified Text is not displayed.");
		testWebHookURLKeyIconHoverText();
	}

	public String verifyEmailFieldValue() {
		// Get the value of the email field
		String actualEmailValue = driver.findElement(webhookURLFieldLocator).getAttribute("value");
		return actualEmailValue;
	}

}
