package selenium.project1.Project_1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(selenium.project1.Project_1.Listeners_Program.class)
public class TestCase9 extends Launch_Quit
{
	@Test(retryAnalyzer = selenium.project1.Project_1.IRetry_Logic.class)
	public void add_to_cart() throws InterruptedException
	{
		Amazon_HomePage ah = new Amazon_HomePage (driver);
		ah.search(driver);
		Amazon_SearchResultPage as = new Amazon_SearchResultPage(driver);
		as.select_product(driver);
		Amazon_Product_DiscriptionPage ap = new Amazon_Product_DiscriptionPage(driver);
		ap.product_details(driver);
		ap.click_add_to_cart(driver);
		Amazon_CartPage ac = new Amazon_CartPage(driver);
		ac.goto_cart(driver);
		
		
		
	}

}
