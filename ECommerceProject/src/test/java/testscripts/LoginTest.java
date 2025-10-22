package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	public HomePage homePage;
	@Test(description= "Verify whether user is able to login using valid credentials")
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
//		loginPage.enterUsername(username);
//		loginPage.enterPassword(password);
		loginPage.enterUsername(username).enterPassword(password);
		homePage = loginPage.clickLogin();
		boolean dashBoardDisplayed = loginPage.isDashboardDisplayed();
		System.out.println("dashBoardDisplayed-->" + dashBoardDisplayed);
		
		Assert.assertTrue(dashBoardDisplayed, "Home page is not displayed");
		// AssertFalse can be used to explicitly make the test case failed
		
	}
	@Test(description = "Verify whether user is able to login using valid username and invalid password")
	@Parameters( {"username","password"})
	public void verifyUserLoginWithValidUsernameAndInvalidPassword(String usr,String passwd) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usr);
		loginPage.enterPassword(passwd);
		loginPage.clickLogin();
		
	}
	@Test(description = "verify whether username and pasword with multiple data sets" ,dataProvider = "credentials")
	public void verifyUsernameAndPasswordWithDataProvider(String usr, String pswd) {
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usr);
		login.enterPassword(pswd);
		login.clickLogin();
		Assert.assertEquals(true, login.isHome());
	}
	
	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object[][] data= { {"admin","test"},{"admin","admin"},{"admin1","test"},{"addmi","tests"} };
		return data;
		
	}
	
}
