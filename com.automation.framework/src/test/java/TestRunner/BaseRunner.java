package TestRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utillities.PropHolder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;


@Test
@CucumberOptions(features="src/test/resources/features",glue={"Steps"},tags= "@Test")

public class BaseRunner extends AbstractTestNGCucumberTests {
	@Parameters({"environment","browser"})
	@BeforeTest
	public void setEnvDetails(@Optional("qa")String environment,@Optional("chrome")String browser) {
		PropHolder.setEnvironment(environment);
		PropHolder.setBrowser(browser);				
		System.out.println("env details initialized");						
	}	
	
}
