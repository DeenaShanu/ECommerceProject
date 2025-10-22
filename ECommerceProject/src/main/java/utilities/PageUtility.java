package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public WebDriver driver ;
	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
		
	}
	public void executeScript(WebElement element,String script, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(script, element);
	}
	public void selectByIndex(WebElement element,int indx) {
		Select select =  new Select(element);
		select.selectByIndex(indx);
		
	}

}
