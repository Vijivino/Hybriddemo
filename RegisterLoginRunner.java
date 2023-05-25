package demoShopRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/RegisterLogin.feature",glue= {"stepDefinitions"},monochrome=true,
                  tags="@withRegister or @onlyLogin",
                //tags="@withExcel",
                 //tags="@onlyLogin",
                  plugin={"pretty","html:htmlreport/RegisterLogin_PF.html",
                		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

           
                
public class RegisterLoginRunner {

}
