package selenium.project1.Project_1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(selenium.project1.Project_1.Listeners_Program.class)
public class TestCase8 extends Launch_Quit
{
	@Test(retryAnalyzer = selenium.project1.Project_1.IRetry_Logic.class)
	public void sort_product()
	{
		Amazon_HomePage ah = new Amazon_HomePage (driver);
		ah.search(driver);
		Amazon_SearchResultPage as = new Amazon_SearchResultPage(driver);
		as.sort_functionality();
	}

}
