package testscripts;


import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	
	@Test(description = "Verify whether user is able to add a new user details")
	public void addNewUserDetails() throws IOException {
		
		String loginUsr = ExcelUtility.getStringData(0, 0, "LoginPage");
		String loginPswd = ExcelUtility.getStringData(0, 1, "LoginPage");
		System.out.println("loginUsr======" + loginUsr);
		System.out.println("loginnPswd====== " + loginPswd);
		
		String newUser = ExcelUtility.getStringData(0, 0, "AdminUser");
		String newPaswd = ExcelUtility.getStringData(0, 1, "AdminUser");
		int index = Integer.parseInt(ExcelUtility.getIntegerData(0, 2, "AdminUser"));
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("admin");
		login.clickLogin();
		
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickLinkAdmin();
		admin.clickNewUser();
		admin.enterUsername(newUser);
		admin.enterPassword(newPaswd);
		admin.selectUserType(index);
	
	}
	
}
