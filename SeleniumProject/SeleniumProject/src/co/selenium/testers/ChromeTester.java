package co.selenium.testers;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTester extends Tester {
	private WebDriver chromeDriver;
	/**
	 * Positive "Google Translate" test for "Chrome" browser: 
	 * Checks if a valid word is translated correctly from English to Hebrew.
	 */
	public boolean checkPositive(String wordToTranslate, String expectedTranslation) {
		setDriver();
		chromeDriver.findElement(By.id("source")).sendKeys(wordToTranslate); // send word to translate
		new WebDriverWait(chromeDriver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("tlid-translation")));
		String actualTranslation = chromeDriver.findElement(By.className("tlid-translation")).getText(); // get translation
		chromeDriver.close();
		return Pattern.compile(expectedTranslation).matcher(actualTranslation).matches(); // compares expected and actual words
	}

	@Override
	void setDriver() {
		chromeDriver = helper.getDriverByBrowser("chrome");
	}
}
