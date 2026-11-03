package selenium.project1.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(selenium.project1.Project_1.Listeners_Program.class)
public class TestCase12 extends Launch_Quit
{
	@Test(retryAnalyzer = selenium.project1.Project_1.IRetry_Logic.class)
	public void select_each_paymnet() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Amazon_HomePage ah = new Amazon_HomePage (driver);
		ah.account_list(driver);
		ah.signin(driver);
		Amazon_LoginPage al = new Amazon_LoginPage( driver);
		al.enter_email();
		al.continue_();
		al.enterPassword();
		al.signin_valid(driver);
		ah.search(driver);
		Amazon_SearchResultPage as = new Amazon_SearchResultPage(driver);
		as.select_product(driver);
		Amazon_Product_DiscriptionPage ap = new Amazon_Product_DiscriptionPage(driver);
		ap.product_details(driver);
		ap.click_add_to_cart(driver);
		Amazon_CartPage ac = new Amazon_CartPage(driver);
		ac.goto_cart(driver);
		Amazon_CheckoutPage acp = new Amazon_CheckoutPage(driver);
		acp.proceed_to_buy();
		acp.use_address(driver);
		acp.credit_debit_card(driver);
		//acp.amazon_balance();
		acp.select_net_banking();
		acp.select_upi_option();
		acp.select_emi_option();
		//acp.select_cod_option(driver);
	}

}
