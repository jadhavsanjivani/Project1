package selenium.project1.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(selenium.project1.Project_1.Listeners_Program.class)
public class TestCase5 extends Launch_Quit
{
		@Test(retryAnalyzer = selenium.project1.Project_1.IRetry_Logic.class)
		public void search_product() throws InterruptedException, EncryptedDocumentException, IOException
		{
			Amazon_HomePage ah = new Amazon_HomePage (driver);
			/*ah.account_list(driver);
			ah.signin(driver);
			Amazon_LoginPage al = new Amazon_LoginPage( driver);
			al.enter_email();
			al.continue_();
			al.enterPassword();
			al.signin_valid(driver);*/
			ah.search(driver);
		}

}
