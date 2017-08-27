package selenium7;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/**  pop up windows:
     1. if the pop up window is part of html code, selenim can handle it as a regular webelement,  html
     2. if the pop up is not from the browser, but from the operating system, selenium can not deal with it.
     
     To work with alerts, we need to create Alert class object at the time when the alert is present.
     If we try to create an alert object while no alerts are present, exception will be thrown
 * 
 * @author Marat Metoff
 *
 */

public class Alerts {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test (priority = 0)
	public void okTest() {
		WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
		jsAlert.click();
		Alert alert = driver.switchTo().alert();                                                                    // alert handling
		alert.accept();
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']")).isDisplayed()); // making sure we handled the alert
		
	}
	
	@Test (priority = 1)
	public void cancelTest() {
		driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();                                 // clicking on alert that gives us two options
		Alert alert = driver.switchTo().alert();
		alert.dismiss();                                                                                            // dismissing: pressing "Cancel"
		Assert.assertTrue(driver.findElement(By.xpath("//p[.='You clicked: Cancel']")).isDisplayed());              // asserting the message is displayed
		
		driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();                                 // clicking again
		alert.accept();                                                                                             // accepting: pressing "Ok"
		Assert.assertTrue(driver.findElement(By.xpath("//p[.='You clicked: Ok']")).isDisplayed());                  // asserting the message is displayed
	}

	@Test (priority = 2)
	public void sendKeysTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Java Language");                                                                             // third type of alert: sending keys
		alert.accept();
		Assert.assertTrue(driver.findElement(By.xpath("//p[.='You entered: Java Language']")).isDisplayed());
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
