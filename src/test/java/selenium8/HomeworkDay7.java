package selenium8;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HomeworkDay7 {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test (priority = 0)
	public void browser_pop_up() {
		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");										// navigating to the page
		driver.findElement(By.id("j_idt87:j_idt88")).click();																	// clicking "Destroy the world"
		assertTrue(driver.findElement(By.id("j_idt87:j_idt89_title")).isDisplayed());											// asserting confirmation dialog is displayed
		driver.findElement(By.id("j_idt87:j_idt91")).click();																	// clicking "No"
	}
	
	@Test (priority = 1)
	public void javascript_alert() {
		driver.get("http://t4t5.github.io/sweetalert/");                                            							// navigating to the page
		driver.findElement(By.cssSelector("div[class = 'showcase normal'] button")).click();        							// clicking on the first "Show error message" button
		Alert alert = driver.switchTo().alert();                                                    							// switching to alert
		assertEquals(alert.getText(), "Oops... Something went wrong!");                             							// asserting the right message is displayed
		alert.dismiss();                                                                            							// dismissing alert
		
		driver.findElement(By.cssSelector("div[class = 'showcase sweet'] button")).click();								    	// clicking on the second "Show error message" button
		assertEquals(driver.findElement(By.cssSelector("p[style = 'display: block;']")).getText(), "Something went wrong!");	// asserting the right message is displayed
	}
	
    @Test (priority = 2)
    public void selenium_demo_sites() {
    	driver.get("http://seleniumframework.com/demo-sites");                                                                  // navigating to the page
    	driver.findElement(By.linkText("http://www.seleniumframework.com/Practiceform/")).click();                              // clicking the link
    	                        
    	tabSwitch(driver,"Selenium Framework |   Practiceform");                                                                // switching to the new tab using our utility method
  
    	assertEquals(driver.getCurrentUrl(), "http://www.seleniumframework.com/Practiceform/");                                 // asserting the current URL
    	driver.findElement(By.id("button1")).click();																			// clicking on "New Browser Window" button
    	
    	tabSwitch(driver, "Selenium Framework | Selenium, Cucumber, Ruby, Java et al.");										// switching to the new browser window using our utility method
    	assertEquals(driver.getCurrentUrl(), "http://www.seleniumframework.com/");                                              // asserting the current URL
    }

    @Test (priority = 3)
    public void yahoo_search() throws InterruptedException {
    	driver.get("http://yahoo.com");     																				    // navigating to the page
    	driver.findElement(By.id("uh-search-box")).sendKeys("how to handle iframe in selenium" + Keys.ENTER);                   // searching
    	Thread.sleep(3000);
    	
    	List<WebElement> webElementList = driver.findElements(By.xpath("//a[@class = ' ac-algo fz-l ac-21th lh-24']"));         // creating a list of WebElements containing links
    	ArrayList<String> stringList = new ArrayList<>();                                                                       // creating a list of Strings containing titles and domains
    	for (WebElement webElement : webElementList) {                                                                          // adding to the String list
    		stringList.add(webElement.getText());
		}
    	
    	ArrayList<String> badStrings = new ArrayList<>();                                                                       // creating a list of links we don't need to avoid ConcurrentModificationException
    	for (String string1 : stringList) {
			if (!string1.contains("-"))																							// adding a link if it doesn't contain hyphen 
				badStrings.add(string1);
			if (string1.contains("java"))																						// adding a link if it contains double hyphen (all start with "java")
				badStrings.add(string1);
		}
    	
    	stringList.removeAll(badStrings);																						// removing all those links we don't need
    	System.out.println("Titles: " + stringList);
    	
    	ArrayList<String> domains = new ArrayList<>();																			// creating a list of domains
    	for (String string2 : stringList) {																						// adding all domains to the list
			domains.add(string2.substring(string2.indexOf("-") + 1).trim());
		}
    	System.out.println("Domains: " + domains);
    	
    	SoftAssert sf = new SoftAssert();																						// soft asserting since some URLs do not contain the domain name exactly as it appears
    	driver.findElement(By.linkText(stringList.get(0))).click();																// 1
    	tabSwitch(driver, stringList.get(0));
    	sf.assertTrue(driver.getCurrentUrl().contains(domains.get(0).toLowerCase().replaceAll("\\s","")));
    	tabSwitch(driver, "how to handle iframe in selenium - Yahoo Search Results");
    	
    	driver.findElement(By.linkText(stringList.get(1))).click();                                                             // 2
    	tabSwitch(driver, stringList.get(1));
    	sf.assertTrue(driver.getCurrentUrl().contains(domains.get(1).toLowerCase().replaceAll("\\s","")));
    	tabSwitch(driver, "how to handle iframe in selenium - Yahoo Search Results");
    	
    	driver.findElement(By.linkText(stringList.get(2))).click();																// 3
    	tabSwitch(driver, stringList.get(2));
    	sf.assertTrue(driver.getCurrentUrl().contains(domains.get(2).toLowerCase().replaceAll("\\s","")));
    	tabSwitch(driver, "how to handle iframe in selenium - Yahoo Search Results");
    	
    	driver.findElement(By.linkText(stringList.get(3))).click();																// 4
    	tabSwitch(driver, stringList.get(3));
    	sf.assertTrue(driver.getCurrentUrl().contains(domains.get(3).toLowerCase().replaceAll("\\s","")));
    	tabSwitch(driver, "how to handle iframe in selenium - Yahoo Search Results");
    	
//    	driver.findElement(By.linkText(stringList.get(4))).click();																// 5th result does not populate sometimes
//    	tabSwitch(driver, stringList.get(4));
//    	sf.assertTrue(driver.getCurrentUrl().contains(domains.get(4).toLowerCase().replaceAll("\\s","")));
//    	tabSwitch(driver, "how to handle iframe in selenium - Yahoo Search Results");											// going back to Yahoo results
    	
    	sf.assertAll();
    }
    
    @Test (priority = 4)
    public void iframe() {
    	driver.get("https://the-internet.herokuapp.com/nested_frames");                                                         // navigating to the page
    	driver.switchTo().frame("frame-top");																					// getting inside the top frame
    	
    	driver.switchTo().frame(0);																								// switching to the left frame
    	System.out.println(driver.findElement(By.cssSelector("body")).getText());
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame("frame-top");
    	
    	driver.switchTo().frame(1);																								// switching to the middle frame
    	System.out.println(driver.findElement(By.cssSelector("body")).getText());
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame("frame-top");
    	
    	driver.switchTo().frame(2);																								// switching to the right frame
    	System.out.println(driver.findElement(By.cssSelector("body")).getText());
    	driver.switchTo().defaultContent();
    	
    	driver.switchTo().frame("frame-bottom");																				// and finally, the bottom frame
    	System.out.println(driver.findElement(By.cssSelector("body")).getText());
    }
    
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
//=================================================================== Utility methods below ======================================================================================	
	
	public void tabSwitch(WebDriver driver, String title) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(title))
				break;
		}
    }
}
