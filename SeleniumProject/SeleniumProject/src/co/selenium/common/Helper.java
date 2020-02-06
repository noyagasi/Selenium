package co.selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Helper {
	/**
	 * WebDriver getter according to browser name.
	 */
	public WebDriver getDriverByBrowser(String browserName) {
		String browser = browserName;
		WebDriver driver = null;
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (driver != null) driver.get("https://translate.google.co.il/?hl=iw");
		return driver;
	}
}
