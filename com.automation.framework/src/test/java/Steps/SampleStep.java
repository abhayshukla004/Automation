package Steps;

import org.testng.Assert;

import com.automation.framework.base.BaseInitialiser;

import io.cucumber.java.en.Given;
// testing12

public class SampleStep extends BaseInitialiser{
	
	
	@Given("user print hello world")
	public void display() throws InterruptedException {
		System.out.println("Inside cucumber");
		driver.get("https://www.google.com");
		Thread.sleep(5000);
//		Assert.assertEquals(true, false);
		driver.close();
	}
}
