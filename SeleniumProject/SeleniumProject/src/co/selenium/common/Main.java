package co.selenium.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import co.selenium.testers.ChromeTester;
import co.selenium.testers.FirefoxTester;

public class Main {
	public static void main(String[] args) {
		
		// test 1: (positive test for Chrome)
		String wordToTranslate = "automation";
		File file = new File("translations\\" + wordToTranslate + ".txt");
		String expectedTranslation = "";
		try {
			expectedTranslation = (new BufferedReader(new FileReader(file))).readLine(); // Hebrew translation to wordToTranslate
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if (new ChromeTester().checkPositive(wordToTranslate, expectedTranslation)) {
			System.out.println("Test 1 passes - expected and actual words are equal.");
		}else {
			System.out.println("Test 1 fails - expected and actual words are not equal.");
		}
		
		// test 2: (negative test for Firefox)
		String invalidWord = "nicw"; // Invalid English word to translate, to the
		if (new FirefoxTester().checkNegative(invalidWord)) {
			System.out.println("Test 2 passes - an invalid word brings a spelling icon as expected.");
		}else {
			System.out.println("Test 2 fails - although an invalid word should not be accepted.");
		}
	}
}
