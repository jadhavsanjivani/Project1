package selenium.project1.Project_1;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Launch_Quit extends Listeners_Program
{
	//WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void launch(String browser)
	{
		if (browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
	}
	
	@AfterMethod
	public void quit() throws InterruptedException
	{
		Thread.sleep(100);
		driver.quit();
	}
	}


