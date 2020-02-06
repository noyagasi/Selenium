package co.selenium.testers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTester extends Tester {
	private WebDriver firefoxDriver;
	/**
	 * Negative "Google Translate" test for "Firefox" browser:
	 * Checks if an invalid word causes "an error".
	 */
	public boolean checkNegative(String invalidWord) {
		setDriver();
		firefoxDriver.findElement(By.id("source")).sendKeys(invalidWord); // send word to translate
		new WebDriverWait(firefoxDriver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("gt-spell-icon")));
		try {
			firefoxDriver.findElement(By.className("gt-spell-icon"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			firefoxDriver.close();
		}
	}

	@Override
	void setDriver() {
		firefoxDriver = helper.getDriverByBrowser("firefox");
	}
}
