package com.automation.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	public static WebDriver createWebDriver(String browserName){
		System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
