package selenium.project1.Project_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_HomePage 
{
	WebDriver driver;
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement countandlist;
	@FindBy(partialLinkText = "Start here.")
	WebElement start_here;
	@FindBy(xpath="//span[.='Sign in']")
	WebElement signin_button;
	@FindBy(id ="twotabsearchtextbox")
	WebElement search_box;
	@FindBy (id = "nav_prefetch_yourorders")
	WebElement your_order;
	
	public void account_list(WebDriver driver) throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
		Actions a1 = new Actions(driver);
		a1.moveToElement(countandlist).perform();	
	}
	public void click_your_order()
	{
		your_order.click();
	}
	public void click_start_here()
	{
		start_here.click();
	}
	public void signin(WebDriver driver)
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Sign in']")));
		Assert.assertEquals(signin_button.isDisplayed(), true, "sign_in button is not displayed");
		signin_button.click();
	}
	public void search(WebDriver driver)
	
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
		search_box.sendKeys("shoes"+Keys.ENTER);
		
		w1.until(ExpectedConditions.titleIs("Amazon.in : shoes"));
		Assert.assertEquals(driver.getTitle(), "Amazon.in : shoes", "product is not searching");
		
	}
	
	public Amazon_HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
		
	}
	


