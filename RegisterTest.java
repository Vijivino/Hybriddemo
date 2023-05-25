package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import demoShopPages.RegisterPage_PF;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {

	private Myhooks hook=null;
	private WebDriver driver=null;
	RegisterPage_PF register;
	
	//create constructor that takes common data from the hooks class as an argument
	public RegisterTest(Myhooks hookobject) {
		this.hook=hookobject;
	}
		
	@When("Click register link")
	public void click_register_link() {
		
		driver=hook.driver;
		register=new RegisterPage_PF(driver);
		register.clickreglink();
		
	}
	
	@When("Select the radio button")
	public void select_the_radio_button() {

	   register.clickRadioBtn();
	}

	@When("Enter the first name and last name")
	public void enter_the_first_name_and_last_name() {

		register.enterNames();
	}

	@When("Enter email and password and confirm password")
	public void enter_email_and_password_and_confirm_password() throws IOException {

		//Configure the property file to get input data
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\Demo\\config.properties");
		prop.load(fis);
		
		register.enteremail(prop.getProperty("email"));
		register.enterpassword(prop.getProperty("password"));
		register.enterconfirmpassword(prop.getProperty("password"));
	}

	@When("Click register button")
	public void click_register_button() {

		register.clickregbtn();
	}    

	@Then("Check registration success message")
	public void check_registration_success_message() {

		register.checkregistration();
		//register.close();
	}




}
