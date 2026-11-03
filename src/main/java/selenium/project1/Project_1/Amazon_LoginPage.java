package selenium.project1.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_LoginPage extends Amz_DDT
{
	WebDriver driver;
	
	@FindBy(name = "email")
	WebElement emailField;
	@FindBy(id = "continue")
	WebElement continue_button;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(id = "signInSubmit")
	WebElement signin_button;
	@FindBy(xpath = "(//span[@class='a-list-item'])[1]")
	WebElement incorrect_email;
	
	public void enter_email() throws EncryptedDocumentException, IOException
	{
		valid_cred();
		emailField.sendKeys(username);
	}
	public void enter_invalid_email() throws EncryptedDocumentException, IOException
	{
		invalid_cred();
		emailField.sendKeys(username);
	}
	
	public void continue_()
	{
		
		continue_button.click();
	}
	public void enterPassword() throws EncryptedDocumentException, IOException
	{
		valid_cred();
		passwordField.sendKeys(pass);
	}
	public void ente_invalid_Password() throws EncryptedDocumentException, IOException
	{
		invalid_cred();
		passwordField.sendKeys(pass);
		System.out.println(pass);
	}
	public void signin_valid(WebDriver driver)
	{
		signin_button.click();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle()=="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")
		{
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Login failed");
		}
		if(driver.getTitle()=="Authentication required")
		{
			Assert.assertEquals(driver.getTitle(), "Authentication required","Login failed");

		}
		
	}
	public void signin_invalid(WebDriver driver)
	{
		signin_button.click();
		//Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Login failed");
		
	}
	public void incorrect_password_msg()
	{
		System.out.println(incorrect_email.getText());
		Assert.assertEquals(incorrect_email.getText(), "We cannot find an account with that email address", "testcase failed login with invalid email");
	}
	public Amazon_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
