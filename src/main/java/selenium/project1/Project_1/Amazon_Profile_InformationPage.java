package selenium.project1.Project_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazon_Profile_InformationPage 
{
	WebDriver driver;
	@FindBy(xpath = "//button[.='Manage Profiles']")
	WebElement manage_profile;
	@FindBy (partialLinkText = "View")
	WebElement view;
	@FindBy (xpath = "//button[@class='edit-pencil-icon-button']")
	WebElement edit_button;
	@FindBy (id = "editProfileNameInputId")
	WebElement edit_profile_name;
	@FindBy (xpath = "(//span[.='Continue'])[1]")
	//@FindBy(id = "save-changes-button")
	WebElement continue_button;
	@FindBy (xpath = "//div[@class='profile-name desktop']")
	WebElement profile_name;
	@FindBy(xpath = "//iframe[@sandbox = 'allow-same-origin allow-scripts']")
	WebElement iframe;
	
	public void click_manage_profile(WebDriver driver) throws InterruptedException
	{
		manage_profile.click();
		view.click();
		edit_button.click();
		edit_profile_name.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		edit_profile_name.sendKeys("sanji");
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(continue_button));
		//driver.switchTo().frame(iframe);
		continue_button.click();
		// Thread.sleep(5000);
	//	WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	   // w2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='profile-name desktop']")));
	   driver.navigate().refresh();
		System.out.println(profile_name.getText());
		Assert.assertEquals(profile_name.getText(),"sanji", "failed to edit profile");
		edit_button.click();
		edit_profile_name.sendKeys(Keys.CONTROL+"a"+Keys.BACK_SPACE);
		edit_profile_name.sendKeys("sanjivani");
		//WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.elementToBeClickable(continue_button));
		//driver.switchTo().frame(iframe);
		continue_button.click();
		edit_button.click();
		w1.until(ExpectedConditions.textToBePresentInElement(edit_profile_name, "sanjivani"));
		 driver.navigate().refresh();
		
	}
	public Amazon_Profile_InformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
