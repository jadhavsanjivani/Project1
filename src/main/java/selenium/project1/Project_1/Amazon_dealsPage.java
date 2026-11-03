package selenium.project1.Project_1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_dealsPage 
{
	WebDriver driver;
	@FindBy (xpath = "(//div[@class = 'a-section a-spacing-mini'])[1]")
	WebElement product;
	@FindBy (id = "add-to-cart-button")
	WebElement add_to_cart_button;
	@FindBy(xpath = "//div[@class='a-checkbox a-checkbox-fancy aok-inline-block checkBoxCSS checkboxOverrides']")
	WebElement click_coupon_box;
	@FindBy (xpath = "//span[@class='a-button a-button-base attach-button-large attach-cart-button']")
	WebElement cart_button;
	@FindBy (partialLinkText = "Go to Cart")
	WebElement go_to_cart;
	@FindBy (partialLinkText = "Collect Coupon")
	WebElement collect_coupon;
	@FindBy ()
    WebElement coupon_collected;	
	
	public void product_with_coupon(WebDriver driver)
	{
		driver.get("https://www.amazon.in/deals?bubble-id=deals-collection-coupons&ref=vp_c_A1MIATEOOKJR8_tcs&discounts-widget=%2522%257B%255C%2522state%255C%2522%253A%257B%255C%2522refinementFilters%255C%2522%253A%257B%257D%257D%252C%255C%2522version%255C%2522%253A1%257D%2522");
		product.click();
		click_coupon_box.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Amazon Sign In"));
		
		Assert.assertTrue(driver.getTitle().contains("Amazon Sign In"));
		
		/*add_to_cart_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		if(cart_button.isDisplayed())
		{
			wait.until(ExpectedConditions.elementToBeClickable(cart_button));
		cart_button.click();
		}
		else
		{
			wait.until(ExpectedConditions.elementToBeClickable(go_to_cart));
			go_to_cart.click();
		
		}	
		
	
		
		wait.until(ExpectedConditions.elementToBeClickable(collect_coupon));
		collect_coupon.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-mini a-color-success sc-clipped-msg a-text-bold']")));
		Assert.assertTrue(coupon_collected.getText().contains("coupon_collected"), "Failed to add coupon");*/
		
	}
	public Amazon_dealsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

}
