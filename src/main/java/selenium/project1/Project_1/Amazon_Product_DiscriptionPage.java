package selenium.project1.Project_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_Product_DiscriptionPage 
{
	WebDriver driver;
	//@FindBy (xpath = "(//i[@class='a-icon a-icon-star a-star-4 cm-cr-review-stars-spacing-big'])[1]")
	@FindBy (id = "acrCustomerReviewText")
	WebElement review;
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement price;
	@FindBy (id = "productTitle")
	WebElement product_discription;
	@FindBy (id = "add-to-cart-button")
	WebElement add_to_cart_button;
	
	
	
	public void product_details(WebDriver driver)
	{
	//	WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='a-icon a-icon-star a-star-4 cm-cr-review-stars-spacing-big'])[2]")));
		Assert.assertTrue(review.isDisplayed(),"Failed to check rating");
		Assert.assertTrue(price.isDisplayed(), "Failed to check price");
		Assert.assertTrue(product_discription.isDisplayed(),"Failed to check discription");
	}
	
	public void click_add_to_cart(WebDriver driver)
	{
		add_to_cart_button.click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart", "Failed add to cart");
		
	}
	public Amazon_Product_DiscriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
