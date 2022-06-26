package Utillities;

public class PropHolder {
	private static String environment;
	private static String browser;
	
	public String getEnvironment() {
		return environment;
	}
	public static void setEnvironment(String env) {
		environment = env;
	}
	public static String getBrowser() {
		return browser;
	}
	public static void setBrowser(String browserName) {
		browser = browserName;
	}
	
	
}
