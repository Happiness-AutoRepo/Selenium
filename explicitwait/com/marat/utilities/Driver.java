package com.marat.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public static WebDriver driver(String browserType) {

		WebDriver driver = null;

		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/Marat Metoff/Documents/Libraries/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		return driver;
	}
}
