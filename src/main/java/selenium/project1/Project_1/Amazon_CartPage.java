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

public class Amazon_CartPage 
{
	WebDriver driver;
	@FindBy (partialLinkText = "Go to Cart")
	WebElement cart;
	@FindBy (xpath = "@FindBy (xpath = \"//span[@class='a-button a-button-base attach-button-large attach-cart-button']\")")
	WebElement cart2;
	@FindBy (xpath = "//span[.='Qty:']")
	WebElement quantitly;
	@FindBy (id = "quantity_2")
	WebElement qunt2;
	@FindBy (xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	WebElement product_price;
	@FindBy (xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
	WebElement subTotal;
	@FindBy (xpath = "(//input[@class='a-color-link'])[1]")
	WebElement delete;
	@FindBy (xpath = "//h2[@class='a-size-extra-large a-spacing-mini a-spacing-top-base a-text-normal']")
	WebElement empty_cart;
	@FindBy(id = "a-popover-content-9")
	WebElement seller_have_1q;
	
	public void goto_cart(WebDriver driver)
	{		
		cart.click();
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart", "Failed add to cart");
				
	}
	public void goto_cart2()
	{		
		cart2.click();
				
	}
	public void click_qauntity(WebDriver driver) throws InterruptedException
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(quantitly));
		quantitly.click();
		qunt2.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")));
		WebDriverWait w4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")));
		String pPrice1 = product_price.getText();
		String total = subTotal.getText();
		String pPrice2 = pPrice1.replaceAll(",", "");
		String total2 = total.replaceAll(",", "");
		System.out.println(pPrice2);
		System.out.println(total2);
	
		double pPrice3 = Double.parseDouble(pPrice2);
		double total3 = Double.parseDouble(total2);
		
		    Assert.assertTrue(total3 == (pPrice3*2), "failed to increse quantity");
		    
		
		WebDriverWait w3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='a-color-link'])[1]")));
		delete.click();
		//driver.navigate().refresh();
		System.out.println(empty_cart.getText());
		Assert.assertTrue(empty_cart.getText().contains("Your Amazon Cart is empty"),"Failed to delete from cart");
	}
	
	public Amazon_CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
