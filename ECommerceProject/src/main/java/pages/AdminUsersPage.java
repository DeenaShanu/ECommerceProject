package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pageUtility =  new PageUtility(driver);

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'admin/list-admin') and @class='small-box-footer']")
	private WebElement linkAdminPage;

	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newUserBtn;
	
	@FindBy(id="username")private WebElement username;
	@FindBy(id="password")private WebElement passwrd;
	@FindBy(id="user_type")private WebElement usrTyp;
	public void clickLinkAdmin() {
//		WaitUtility wait = new WaitUtility();
//		wait.elementToBeClickable(driver, linkAdminPage);
//		PageUtility pageUtility = new PageUtility(driver);
//		pageUtility.executeScript(linkAdminPage, "arguments[0].click();", driver);
		linkAdminPage.click();
		
	}
	public void clickNewUser() {
		newUserBtn.click();
		
	}
	public void enterUsername(String usrnme) {
		username.sendKeys(usrnme);
		
	}
	public void enterPassword(String pswd) {
		passwrd.sendKeys(pswd);
	}
	public void selectUserType(int index) {
		pageUtility.selectByIndex(usrTyp, index);
	}
}
