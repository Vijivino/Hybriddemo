package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Myhooks {
	//Hooks class holds the common data

	public WebDriver driver=null;

	@Before
	public void setup() throws IOException {

		//Launching the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) {

			TakesScreenshot ts= (TakesScreenshot) driver;
			byte[] scn= ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(scn, "image/png", scenario.getName());

//			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"contact us displayed---log statement")
//		.addScreenCaptureFromPath("/Screenshots/embedded1.PNG");
	}

	@After
	public void close(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			TakesScreenshot ts= (TakesScreenshot) driver;
			byte[] scn= ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(scn, "image/png", scenario.getName());
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"This step failed---log statement");
		}
		
		driver.quit();

	}



}
