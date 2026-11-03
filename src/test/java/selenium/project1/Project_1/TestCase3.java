package selenium.project1.Project_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(selenium.project1.Project_1.Listeners_Program.class)

public class TestCase3 extends Launch_Quit
{
	@Test(retryAnalyzer = selenium.project1.Project_1.IRetry_Logic.class)
	public void invalid_login() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Amazon_HomePage ah = new Amazon_HomePage (driver);
		ah.account_list(driver);
		ah.signin(driver);
		Amazon_LoginPage al = new Amazon_LoginPage( driver);
		al.enter_invalid_email();
		al.continue_();
		//al.ente_invalid_Password();
		//al.signin_invalid(driver);
		al.incorrect_password_msg();
	}

}
