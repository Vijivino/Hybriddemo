package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import demoShopPages.LoginPage_PF_Excel;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginExcelTest {

	private Myhooks hook=null;
	private WebDriver driver=null;
	LoginPage_PF_Excel login;

	public LoginExcelTest(Myhooks hookobject) {
		this.hook=hookobject;
	}
	
	
	@When("Click the login link")
	public void click_the_login_link() {

		driver=hook.driver;
		login=new LoginPage_PF_Excel(driver);
		login.clickloginlink();

	}
	@When("Enter email and password from excelsheet {string} and rownumber {int}")
	public void enter_email_and_password_from_excelsheet_and_rownumber(String sheetname, Integer rownum) throws IOException {

		//Excel data 
		File credentials=new File("C:\\Selenium Software\\Book1.xlsx");
		FileInputStream credeObj=new FileInputStream(credentials);
		XSSFWorkbook exfile=new XSSFWorkbook(credeObj);
		XSSFSheet sheet1=exfile.getSheetAt(0);
		//int rowNum = sheet1.getLastRowNum();

		String email = sheet1.getRow(rownum).getCell(0).getStringCellValue();
		String password=sheet1.getRow(rownum).getCell(1).getStringCellValue();
		System.out.println(email +" "+password);
		login.enteremail(email);
		login.enterpassword(password);
        exfile.close();

	}
	@When("Click the login button")
	public void click_the_login_button() {

		login.clickloginbtn();

	}
	@Then("Validate login functionality")
	public void validate_login_functionality() {

		login.logincheck();
		//login.close();
	}


}
