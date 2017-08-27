package com.marat.test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.marat.pages.MainPage;
import com.marat.utilities.Driver;


public class SpeedTest {
		
	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser", "URL"})
	public void setUp(String browser, String URL) {
		driver = Driver.driver(browser);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@Test
	public void Test() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		assertTrue(mainPage.goButton.isDisplayed());
		mainPage.goButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(mainPage.downloadResult));
		assertTrue(mainPage.downloadResult.isDisplayed());

		wait.until(ExpectedConditions.visibilityOf(mainPage.uploadResult));
		assertTrue(mainPage.uploadResult.isDisplayed());
		
		wait.until(ExpectedConditions.invisibilityOf(mainPage.speedWindow));
		assertTrue(!mainPage.speedWindow.isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	} 
}
