package selenium.project1.Project_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_OrderPage 
{
	WebDriver driver;
    @FindBy(partialLinkText = "Leave seller feedback")
	WebElement feedback;
    @FindBy (name = "star5")
    WebElement rating;
    @FindBy (name = "submitFeedback")
    WebElement submit_feedback;
    @FindBy (name = "ItemAsDescribed")
    WebElement item_feedback;
    @FindBy (xpath = "(//label[@class='yellowStar'])[5]")
    WebElement yellow;
    @FindBy (id = "text5")
    WebElement text;
    
    
    public void leave_feedback()
    {
    	feedback.click();
    	rating.click();
    	submit_feedback.click();
    	Assert.assertEquals(text.getText().contains("Excellent"), true, "failed to give rating");


    	
    }
    
    public Amazon_OrderPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	

}
