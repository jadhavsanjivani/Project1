package selenium.project1.Project_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_ResistarionPage 
{
	WebDriver driver;
	@FindBy(id = "ap_customer_name")
	WebElement name;
	@FindBy(name = "email")
	WebElement mobile_number;
	@FindBy(name ="password")
	WebElement pass;
	@FindBy(id = "continue")
	WebElement verify_mob_num;
	@FindBy(xpath = "(//div[@class='a-row a-spacing-mini'])[1]")
	WebElement solve_puzzle;
	
	public void name_field()
	{
    	
		name.sendKeys("Sanji");
	}
	public void mobile_number_field()
	{
		mobile_number.sendKeys("9876543210");
	}
	public void password_field()
	{
		pass.sendKeys("Sanji@123");
	}
	public void verify_button(WebDriver driver)
	{
		
		verify_mob_num.click();
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.titleIs("Authentication required"));
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Authentication required", "Registration failed");
		
	}
	/*public void solve_puzzle_box(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='a-row a-spacing-mini'])[1]")));
		System.out.println(solve_puzzle.getText());
	}*/
	
	public Amazon_ResistarionPage(WebDriver driver)
	{
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
