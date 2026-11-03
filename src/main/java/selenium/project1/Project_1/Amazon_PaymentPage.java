package selenium.project1.Project_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_PaymentPage
{
	WebDriver driver;
    WebDriverWait wait;

	@FindBy(linkText = "Enter card details")
	WebElement card_details;
	@FindBy(name = "addCreditCardNumber")
	WebElement card_number;
	@FindBy (name = "ppw-accountHolderName")
	WebElement nickname;
	@FindBy(name = "ppw-expirationDate_month")
	WebElement expiry_date;
	@FindBy(name = "ppw-expirationDate_year")
	WebElement expiry_year;
	@FindBy(name = "ppw-widgetEvent:AddCreditCardEvent")
	WebElement enter_card_details_button;
	@FindBy (name = "ApxSecureIframe")
	WebElement iframe;
	@FindBy (id = "field")
	WebElement cvv;
	@FindBy (id = "pp-qqzoZX-129")
	WebElement save_card;
	@FindBy (xpath = "(//span[.='Use this payment method'])[1]")
	WebElement usethis_payment;
	@FindBy (name = "apx-secure-field-addCreditCardVerificationNumber")
	WebElement iframe2;
	@FindBy (xpath = "//span[@class='a-button a-spacing-top-medium a-button-primary']")
	WebElement save_continue;
	@FindBy (id = "spc-desktop")
	WebElement review_order;
	public void card_details(WebDriver driver)
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(card_details));
		card_details.click();
	}
	public void card_number(WebDriver driver)
	{
		driver.switchTo().frame(iframe);
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOf(card_number));
		card_number.sendKeys("5143687330385981");
		nickname.sendKeys(Keys.CONTROL+"a" + Keys.BACK_SPACE);
		nickname.sendKeys("Gretta Raya");
		
	}
	public void expirydate() throws InterruptedException
	{
		Select s1 = new Select(expiry_date);
		s1.selectByVisibleText("01");
		Select s2 = new Select(expiry_year);
		s2.selectByIndex(5);
		//Thread.sleep(5000);
	}
	public void enter_card_details_button(WebDriver driver) throws InterruptedException
	{
		enter_card_details_button.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}
	public void enter_cvv(WebDriver driver) throws InterruptedException
	{
		driver.switchTo().frame(iframe2);
		Thread.sleep(3000);
		cvv.sendKeys("839");
		driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   // wait.until(ExpectedConditions.elementToBeClickable(save_card));
		//save_card.click();
		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	   // wait1.until(ExpectedConditions.visibilityOf(cvv));
		
		
		usethis_payment.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait2.until(ExpectedConditions.elementToBeClickable(save_continue));
		save_continue.click();
		//System.out.println();
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("spc-desktop")));
		Assert.assertTrue(review_order.isDisplayed());
		
	}
	/*public void enter_cvv(WebDriver driver) throws InterruptedException
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(save_card)).click();
	    wait.until(ExpectedConditions.visibilityOf(cvv)).sendKeys("839");
	    wait.until(ExpectedConditions.elementToBeClickable(usethis_payment)).click();
	}*/
	
	public Amazon_PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
