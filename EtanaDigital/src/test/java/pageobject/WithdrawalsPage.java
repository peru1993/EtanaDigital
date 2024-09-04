package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class WithdrawalsPage extends BasePage {

	public WithdrawalsPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	By investorTextLocator = By.xpath("//div[normalize-space(text())='INVESTOR']");
	By csvTransactionButtonLocator = By.xpath("//button[contains(.,'CSV (transactions)')]");
	By jsonTransactionButtonLocator = By.xpath("//button[contains(.,'JSON (transactions)')]");
	By withdrawalsButtonLocator = By.xpath("(//button[@type='button'])[2]");
	By mouseOverIconLocator = By.xpath("//div[@class='flex space-x-2']//*[name()='svg' and @data-slot='icon']");
	By mouseOverTextLocator = By.xpath(
			"// div[normalize-space(text())='Downloading this type of document in CSV format may result in data loss']");
	By filterIconLocator = By.xpath("//*[local-name()='svg' and @data-slot='icon' and @class='w-4']");
	By filterTextLocator = By.xpath("//span[normalize-space(text())='Filter']");
	By ClearButtonLocator = By.xpath("//div[normalize-space(text())='Clear All']");
	By networkscheckbox = By.xpath("(//input[@type='checkbox'])[1]");
	By networksLabelLocator = By.xpath("//div[normalize-space(text())='Networks']");
	By networksBitcoinLocator = By.xpath("//label[normalize-space(text())='Bitcoin']");
	By networksEthereumLocator = By.xpath("//label[normalize-space(text())='Ethereum']");
	By networksAvalancheLocator = By.xpath("//label[normalize-space(text())='Avalanche']");
	By networksPolymeshLocator = By.xpath("//label[normalize-space(text())='Polymesh']");
	By approvalStatusLabelLocator = By.xpath("//div[normalize-space(text())='Approval Status']");
	By approvalStatusApprovedLabelLocator = By.xpath("//label[normalize-space(text())='Approved']");
	By approvalStatusPendingLabelLocator = By.xpath("//label[normalize-space(text())='Pending']");
	By approvalStatusRejectedLabelLocator = By.xpath("//label[normalize-space(text())='Rejected']");
	
	//datashwoinglocator:
	By bitcoinlogoLocator = By.xpath("//img[@title='Bitcoin']");
	By ethereumlogoLocator = By.xpath("//img[@title='Ethereum']");
	By avalanchelogoLocator = By.xpath("//img[@title='Avalanche']");
	By polymeshlogoLocator = By.xpath("//img[@title='Polymesh']");
	
	//Approvallogolocator:
	By approvedlogoLocatore = By.xpath("//td[@class='bg-gradient-to-br from-emerald-400/25 via-green-400/75 to-green-700 w-2 border-x border-white false']");
	By pendinglogoLocatore = By.xpath("//td[@class='bg-gradient-to-br from-gray-500/25 via-gray-600/75 to-gray-800/50 w-2 border-x border-white']");
	By rejectedlogoLocatore = By.xpath("//td[@class='bg-gradient-to-br from-red-500/25 via-red-600/75 to-red-800/50 w-2 border-x border-white']");
	
	
	// Methods to interact with elements
	// Page actions

	public WithdrawalsPage clickWithdrawalsButton() {
		clickElement(withdrawalsButtonLocator, "clickWithdrawals");
		return this;
	}

	// code for Filter icon and text necessary field

	public WebElement getFilterIconElement() {
		SmartWait(1);
		return driver.findElement(filterIconLocator);
	}

	public WebElement getFilterTextElement() {
		SmartWait(1);
		return driver.findElement(filterTextLocator);
	}

	public WebElement getNetWorksTextElement() {
		SmartWait(1);
		return driver.findElement(networksLabelLocator);
	}

	public WebElement getnetWorksBitcoinLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(networksBitcoinLocator);
	}

	public WebElement getnetworksEthereumLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(networksEthereumLocator);
	}

	public WebElement getnetworksAvalancheLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(networksAvalancheLocator);
	}

	public WebElement getnetworksPolymeshLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(networksPolymeshLocator);
	}

	public WebElement getapprovalStatusLabelLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(approvalStatusLabelLocator);
	}

	public WebElement getapprovalStatusApprovedLabelLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(approvalStatusApprovedLabelLocator);
	}

	public WebElement getapprovalStatusPendingLabelLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(approvalStatusPendingLabelLocator);
	}

	public WebElement getapprovalStatusRejectedLabelLocatorTextElement() {
		SmartWait(1);
		return driver.findElement(approvalStatusRejectedLabelLocator);
	}
	
	public WithdrawalsPage clickClearButton() {
		clickElement(ClearButtonLocator, "ClearAll_click");
        SmartWait(1);
        return this;
	}

	
	public void verifyAllFilterElements() {
		Assert.assertTrue(getNetWorksTextElement().isDisplayed(), "NetWorks Text is not displayed.");
		Assert.assertTrue(getnetWorksBitcoinLocatorTextElement().isDisplayed(),
				"NetWorks Bitcoin Text is not displayed.");
		Assert.assertTrue(getnetworksEthereumLocatorTextElement().isDisplayed(),
				"NetWorks Ethereum Text is not displayed.");
		Assert.assertTrue(getnetworksAvalancheLocatorTextElement().isDisplayed(),
				"NetWorks Avalanche Text is not displayed.");
		Assert.assertTrue(getnetworksPolymeshLocatorTextElement().isDisplayed(),
				"NetWorks Polymesh Text is not displayed.");
		Assert.assertTrue(getapprovalStatusLabelLocatorTextElement().isDisplayed(),
				"Approval Status Text is not displayed.");
		Assert.assertTrue(getapprovalStatusApprovedLabelLocatorTextElement().isDisplayed(),
				"Approval Status Approved Text is not displayed.");
		Assert.assertTrue(getapprovalStatusPendingLabelLocatorTextElement().isDisplayed(),
				"Approval Status Pending Text is not displayed.");
		Assert.assertTrue(getapprovalStatusRejectedLabelLocatorTextElement().isDisplayed(),
				"Approval Status Rejected Text is not displayed.");
	}
	

	public void getClearButtonStatus() {
		WebElement clearAllDiv = driver.findElement(ClearButtonLocator);
		String classAttribute = clearAllDiv.getAttribute("class");
		if (classAttribute.contains("cursor-not-allowed")) {
			System.out.println("The 'Clear All' button is disabled.");
		} else {
			System.out.println("The 'Clear All' button is not disabled.");
		}
	}

	public WithdrawalsPage clickFilterButton() {
		clickElement(filterTextLocator, "Filter_click");
		SmartWait(1);
		return this;
	}

	// checkbox selection

	public WithdrawalsPage selectNetworkscheckbox() {
		SmartWait(1);
		clickElement(networksBitcoinLocator, "selectNetworksBitcoincheckbox");
		clickElement(networksEthereumLocator, "selectNetworksEthereumcheckbox");
		clickElement(networksAvalancheLocator, "selectNetworksAvalanchecheckbox");
		clickElement(networksPolymeshLocator, "selectNetworksPolymeshcheckbox");
		return this;
	}

	public void testIconHoverText() {

		// Retrieve WebElement
		WebElement svgElement = driver.findElement(mouseOverIconLocator);

		// Perform mouse hover action on the SVG element
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();

		// Locate the text element that appears after hover
		WebElement hoverTextElement = driver.findElement(mouseOverTextLocator);

		// Assert the text content
		String expectedText = "Downloading this type of document in CSV format may result in data loss";
		String actualText = hoverTextElement.getText();
		Assert.assertEquals(actualText, expectedText, "Hover text does not match the expected value.");
	}

	public WebElement getinvestor() {
		SmartWait(2);
		return driver.findElement(investorTextLocator);
	}

	public void clickCSVAndJSONTransactions() {
		clickWithdrawalsButton();
		testIconHoverText();
		clickElement(csvTransactionButtonLocator, "csv transactions");
		clickElement(jsonTransactionButtonLocator, "JSON transactions");
	}
	
	

	
	 // Method to get Bitcoinfiltered results
    public void getBitcoinFilteredResults() {
    	SmartWait(1);
    	List<WebElement> elements = driver.findElements(bitcoinlogoLocator);
    	for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed(), "Element is not displayed.");
        }
    	clickClearButton();
    	getClearButtonStatus();
    }
    

  
    
    // Method to get Approved filtered results
    public void getApprovedFilteredResults() {
    	SmartWait(1);
    	List<WebElement> elements = driver.findElements(approvedlogoLocatore);
    	for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed(), "Element is not displayed.");
        }
//    	clickClearButton();
//    	getClearButtonStatus();
    }
    
    
    

}
