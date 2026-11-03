package selenium.project1.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(selenium.project1.Project_1.Listeners_Program.class)
public class TestCase13 extends Launch_Quit
{
	@Test(retryAnalyzer = selenium.project1.Project_1.IRetry_Logic.class)
	public void add_coupon() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Amazon_HomePage ah = new Amazon_HomePage (driver);
		ah.account_list(driver);
		//ah.signin(driver);
		//Amazon_LoginPage al = new Amazon_LoginPage( driver);
		//al.enter_email();
		//al.continue_();
		//al.enterPassword();
		//al.signin_valid(driver);
		
		//Amazon_Product_DiscriptionPage ap = new Amazon_Product_DiscriptionPage(driver);
		//ap.click_add_to_cart(driver);
		//Amazon_CartPage ac = new Amazon_CartPage(driver);
		//ac.goto_cart2();
		Amazon_dealsPage ad = new Amazon_dealsPage(driver);
		ad.product_with_coupon(driver);
	}


}
