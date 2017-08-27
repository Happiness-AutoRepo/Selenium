package selenium7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/**
 * iframe/frame - this tag is used to put one html document inside another.
   to work with elements inside iframe using selenium, we need to jump to the frame
   
   there are 3 ways of switching to iframes
   1. using id
   2. using webelement
   3. using index


 * @author Marat Metoff
 *
 */

public class IframeTest {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                         // this line is only working when Selenium can't find the element, it will try multiple times for 10 sec and then throw an exception.
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test
	public void iframeTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/iframe");
		Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());                  // asserting link is displayed in main html window
		
		driver.switchTo().frame("mce_0_ifr");                                                                    // jumping to an embedded frame (if there's no id, use tagName("iframe"))
		WebElement body = driver.findElement(By.id("tinymce"));                                                  // now we can work with this frame
		body.clear();
		body.sendKeys("Java language");																			 // sending keys
		System.out.println(body.getText());
		                                                                                                         // once Selenium jumps inside the iframe it will not see the main document
		driver.switchTo().defaultContent();                                                                      // switching from the iframe to the main page
		Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());                  // now we can work with the contents of the page again 
		
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
