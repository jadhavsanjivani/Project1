package selenium.project1.Project_1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_SearchResultPage 
{
	WebDriver driver;
	@FindBy (id = "n/1983610031")
	WebElement category;
	@FindBy (xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	WebElement category_result;
	@FindBy (xpath = "//span[.='Sort by:']")
	WebElement sort_dropdown;
	@FindBy (partialLinkText = "Price: High to Low")
	WebElement high_low_value;
	@FindBy (xpath = "(//span[@class='a-price'])[1]")
	WebElement high_value;
	@FindBy (xpath ="(//span[@class='a-price'])[25]")
	WebElement low_value;
	

	public void select_category()
	{
		category.click();
		System.out.println(category_result.getText());
		Assert.assertTrue(category_result.getText().contains("Women"), "Failed to search category");
	}
	public void select_product(WebDriver driver)
	{
		category_result.click();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentId =  i1.next();
		String childId = i1.next();
		driver.switchTo().window(childId);				
	}
	
	public void sort_functionality()
	{
		sort_dropdown.click();
		high_low_value.click();
		System.out.println(high_value.getText());
		System.out.println(low_value.getText());
		String high1 = high_value.getText();
		String high2 = high1.replaceAll("[^\\d.]", "");
		String high3 = high2.replace("\n", "");
		System.out.println(high3);
		String low1 = low_value.getText();
		String low2 = low1.replaceAll("[^\\d.]", "");
		String low3 = low2.replace("\n", "");
		System.out.println(low3);
		double high = Double.parseDouble(high3);
		double low = Double.parseDouble(low3);
		Assert.assertTrue(high>low, "sort functionality failed");
	}
	
	
	
	
	public Amazon_SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
