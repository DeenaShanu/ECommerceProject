package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	
	
	public WebDriver driver;
	@Parameters("browsers")
	@BeforeMethod(alwaysRun=true)
	public void initialiseBrowser(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
		driver = new ChromeDriver();
		} else {
			throw new Exception("invalid browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void quit() {
		//driver.close();
	}
}
