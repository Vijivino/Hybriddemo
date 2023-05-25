package demoShopPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage_PF {

	WebDriver driver;


	//object repository,Storing the locators using page factory
	@FindBy(linkText="Register") WebElement registerlink;
	@FindBy(how = How.XPATH, using = "//label[text()='Female']") WebElement femalebutton;
	@FindBy(name="FirstName") WebElement firstname;
	@FindBy(name="LastName") WebElement lastname;
	@FindBy(name="Email") WebElement email;
	@FindBy(name="Password") WebElement password;
	@FindBy(name="ConfirmPassword") WebElement confirmpassword;
	@FindBy(xpath="//input[@value='Register']") WebElement registerbutton;
	@FindBy(xpath="//li[contains(text(),'already')]") WebElement registeralready;


	public RegisterPage_PF(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickreglink() {

		registerlink.click();
	}

	public void clickRadioBtn() {

		femalebutton.click();
	}

	public void enterNames() {

		firstname.sendKeys("viji");
		lastname.sendKeys("a"); 
	}

	public void enteremail(String em) {

		email.sendKeys(em);
	}

	public void enterpassword(String pw) {

		password.sendKeys(pw);
	}

	public void enterconfirmpassword(String pw) {

		confirmpassword.sendKeys(pw);
	}

	public void clickregbtn() {

		registerbutton.click();
	}

	public void checkregistration() {

		boolean displayed = registeralready.isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println("Registration done already");

	}

	public void close() 
	{
		driver.quit();
	}


}
