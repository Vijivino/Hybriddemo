package demoShopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_PF_Excel {

	WebDriver driver;

	@FindBy(linkText = "Log in") WebElement loginlink;
	@FindBy(id = "Email") WebElement emailinputbox;
	@FindBy(name = "Password") WebElement pwinputbox;
	@FindBy(xpath = "//input[@value='Log in']") WebElement loginbtn;
	@FindBy(xpath = "//a[contains(text(),'viji')]") WebElement loginnamelocator;

	public LoginPage_PF_Excel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickloginlink()
	{
		loginlink.click();
	}

	public void enteremail(String em) 
	{
		emailinputbox.sendKeys(em);
	}

	public void enterpassword(String pw) 
	{
		pwinputbox.sendKeys(pw);
	}

	public void clickloginbtn() 
	{
		loginbtn.click();
	}

	public void logincheck() 
	{
		String text = loginnamelocator.getText();
		Assert.assertTrue(text.contains("viji"));
		System.out.println("login was successful with id -- "+text);
	}

    public void close() {
    	driver.quit();
    }

}
