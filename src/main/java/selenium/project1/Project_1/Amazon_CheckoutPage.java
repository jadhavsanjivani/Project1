package selenium.project1.Project_1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_CheckoutPage 
{
WebDriver driver;
	
	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceed_to_buy;
	@FindBy (xpath = "(//input[@class='a-button-input'])[6]")
	WebElement use_this_address;
	@FindBy(xpath = "//input[@value='SelectableAddCreditCard']")
	WebElement credit_debit_card;
	@FindBy (xpath = "//input[@value ='instrumentId=APB&isExpired=false&paymentMethod=APB&tfxEligible=false']")
	WebElement amazon_pay_balance;
	@FindBy (xpath = "//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")
	WebElement net_banking;
	@FindBy (xpath = "//input[@value = 'instrumentId=amzn1.pm.poa.YW16bjEucG9hOmFtem4xLnBvYS5wb2RhLlVuaWZpZWRQYXltZW50c0ludGVyZmFjZTox.QTFFWVI2STVDRzhUWUE&isExpired=false&paymentMethod=UnifiedPaymentsInterface&tfxEligible=false']")
	WebElement upi_option;
	@FindBy (xpath = "//input[@value = 'instrumentId=EMI&isExpired=false&paymentMethod=CC&tfxEligible=false']")
	WebElement emi_option;
	@FindBy (xpath = "//input[@value = 'instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']")
	WebElement cod;
	public void proceed_to_buy()
	{
		proceed_to_buy.click();
	}
	public void use_address(WebDriver driver)
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(use_this_address));
		use_this_address.click();
	}
	public void credit_debit_card(WebDriver driver)
	{
		
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(credit_debit_card));
		credit_debit_card.click();
		Assert.assertTrue(credit_debit_card.isSelected(),"failed to select credit card option");
	}
	public void amazon_balance() throws InterruptedException
	{
		Thread.sleep(2000);
		amazon_pay_balance.click();
		//Assert.assertTrue(amazon_pay_balance.isSelected(), "failed to select amazon pay balance");
	}
	public void select_net_banking() throws InterruptedException
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(net_banking));
		
		net_banking.click();
		//Thread.sleep(2000);
		Assert.assertTrue(net_banking.isSelected(), "failed to select net banking");
	}
	public void select_upi_option() throws InterruptedException
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(upi_option));
		upi_option.click();
		//Thread.sleep(2000);
		Assert.assertTrue(upi_option.isSelected(), "failed to select upi option");
	}
	public void select_emi_option() throws InterruptedException
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(emi_option));
		emi_option.click();
		Thread.sleep(2000);
		Assert.assertTrue(emi_option.isSelected(), "failed to select upi option");
	}
	public void select_cod_option(WebDriver driver) throws InterruptedException
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(cod));
		cod.click();
	//	Thread.sleep(2000);
		Assert.assertTrue(cod.isSelected(), "failed to select upi option");
	}
	
	public Amazon_CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
