package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import demoShopPages.LoginPage_PF;
import demoShopPages.UserPage_PF;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	private Myhooks hook=null;
	private WebDriver driver=null;
	LoginPage_PF login;
	UserPage_PF user;
	
	public LoginTest(Myhooks hookobj) {
		this.hook=hookobj;
	}

	@When("Click login link")
	public void click_login_link() {

		driver=hook.driver;
		login=new LoginPage_PF(driver);
		login.clickloginlink();
	}

	@When("Enter email and password")
	public void enter_email_and_password() throws IOException {

		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\Demo\\config.properties");
		prop.load(fis);
		login.enteremail(prop.getProperty("email"));
		login.enterpassword(prop.getProperty("password"));
	}	

	@When("Click login button")
	public void click_login_button() {

		login.clickloginbtn();
	}

	@Then("Validate the login functionality")
	public void validate_the_login_functionality() {

		login.logincheck();
	}
	
	@When("Click Logout link")
	public void click_logout_link() {
	     
		driver=hook.driver;
		user=new UserPage_PF(driver);
		user.clicklogout();
		//user.close();
		
	}


	

}
