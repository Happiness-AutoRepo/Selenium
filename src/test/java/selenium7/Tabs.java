package selenium7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/** Selenium doesn't distinguish between a new tab and a new window:
 *  in both cases Selenium still controls the first window.
 * @author Marat Metoff
 *
 */


public class Tabs {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test (priority = 0)
	public void tabsTest() {
		String target = "Selenium Framework | Practiceform";                                       // our target title for the page that we want to control and we want to switch to 
		
		driver.get("http://www.seleniumframework.com/demo-sites/");                                // getting URL and title from the first page
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("http://www.seleniumframework.com/Practiceform/")).click(); // clicking on the element that was built to open the new tab(we don't open the new tab by ourselves)
		System.out.println("It's clicked");                                                        // trying to get URL and title from the second page - failure: same title and URL(Selenium is still sitting in the first tab, although we see the second tab open)
		System.out.println(driver.getTitle());                                                     // we need to do an explicit switching to control the tab we need;
		System.out.println(driver.getCurrentUrl());
		System.out.println("--------------------------------------");
		
		
		
		for (String windowHandle : driver.getWindowHandles()) {                                    // WindowHandle is an ID that we can use to grab the window we need
			driver.switchTo().window(windowHandle);                                                // switching to the window that has particular WindowHandle
			System.out.println(driver.getTitle());                                                 // printing the title of particular tab
			System.out.println(windowHandle);                                                      // looking at how WindowHandle looks like (CDwindow-3baaad55-f60b-4e04-a3d8-a50fb5292ae5)
			if (driver.getTitle().equals(target)) {                                                // breaking the loop once we are on the right tab
				break;
			}
		}
	}

	@Test (priority = 1)
	public void YahooTest() {
		String title = "Selenium - Web Browser Automation";
		
		driver.get("http://www.yahoo.com");
		driver.findElement(By.id("uh-search-box")).sendKeys("Selenium" + Keys.ENTER);               // Yahoo opens links in a new tab by default
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		switchTab(driver, title);                                                                   // using our method
		Assert.assertEquals(driver.getTitle(),"Selenium - Web Browser Automation");                 // asserting we are on the right tab
			
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();                                                                               // quit() kills all the tabs, close() will close the current tab only - very useful if you need to figure out which tab are on 
	}
	
	
//==================================================================================================================================================================================================================================	
// All utility methods below	
	
	
	public static void switchTab(WebDriver driver, String title) {                                   // creating the method for switching tabs
		
		for (String windowHandle : driver.getWindowHandles()) {                                    
			driver.switchTo().window(windowHandle);                                                                                                     
			if (driver.getTitle().equals(title)) {                                                
				break;
			}
		}
		
	}

}

