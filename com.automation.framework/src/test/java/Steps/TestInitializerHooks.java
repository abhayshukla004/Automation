package Steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.framework.base.BaseInitialiser;
import com.automation.framework.base.BrowserFactory;
import Steps.TestInitializerHooks;

import ProjectLib.GlobalVariables;

import Utillities.PropHolder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestInitializerHooks extends BaseInitialiser{
	private static Logger logger = Logger.getLogger(TestInitializerHooks.class);
	public static Scenario sc;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		String browserName=PropHolder.getBrowser();
		driver = BrowserFactory.createWebDriver(browserName);		
		GlobalVariables.CurrentScenarioName = scenario.getName();
		sc=scenario;
		System.out.println("******Scenario******"+scenario.getName()+"******Started");
		logger.info("******Scenario******"+scenario.getName()+"******Started");
	}
	@After
	public void afterScenario(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			takeScreenshot();
		}
		if(driver!=null) {
			driver.quit();
			logger.info("Browser Closed");
		}
	}
	public static void takeScreenshot() throws IOException {
//		String screenshotName = sc.getName().replaceAll(" ", "");
//		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		sc.attach(sourcePath, "image/png", screenshotName);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\Reports\\Screenshots\\homepage.png");
		FileUtils.copyFile(src,target);
	}

}
