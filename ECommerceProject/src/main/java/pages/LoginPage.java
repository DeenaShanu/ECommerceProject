package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']") private  WebElement username;
	@FindBy(xpath = "//input[@name='password']") private WebElement password;
	@FindBy(xpath="//button[text() = 'Sign In']")private WebElement loginBtn;
	@FindBy(xpath="//li[text()='Dashboard']") private WebElement dashBoard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement errMsg;
	
	public LoginPage enterUsername(String user_name) {
		username.sendKeys(user_name);
		return this;
	}
	public LoginPage enterPassword(String pass_word) {
		password.sendKeys(pass_word);
		return this;
	}
	public HomePage clickLogin() {
		loginBtn.click();
		return new HomePage(driver);
	}
	public boolean isDashboardDisplayed() {
		return dashBoard.isDisplayed();
	}
	public boolean isHome() {
		return errMsg.isDisplayed();
	}
}
