package demoShopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage_PF {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Log outt']") WebElement logoutlink;
	
	public UserPage_PF(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void clicklogout() {
		logoutlink.click();
	}
	
	public void close() {
    	driver.quit();
    }

}
