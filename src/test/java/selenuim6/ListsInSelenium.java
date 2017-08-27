package selenuim6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ListsInSelenium {
  
  WebDriver driver; 	
	
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test (priority = 0)
  public void listTest() {
	  driver.get("https://www.google.com");
	  List<WebElement>links = driver.findElements(By.tagName("a"));
	  System.out.println(links.size());
	  System.out.println(links.get(10).getText()); // there's no text there, so it won't print anything;
	  
	  //========= How many Buttons are there on the page? ==================
	  List<WebElement> buttons = driver.findElements(By.xpath("//input[@type = 'submit']"));
	  System.out.print("Number of buttons on Google website: ");
	  System.out.println(buttons.size());
  }
  
  @Test (priority = 1)
  public void findImages() throws InterruptedException {
	  
	  // =============== How many images are on the page? ==========================
	  driver.get("https://www.etsy.com");
	  
	  Thread.sleep(2000); // gives pictures some time to load
	  
	  List<WebElement> images = driver.findElements(By.tagName("img"));
	  System.out.print("Number of images on Etsy website: ");
	  System.out.println(images.size());
  }
  
  @Test (priority = 2)
  public void printAllLinks() throws InterruptedException {
      
	  // ================ Print all visible links =======================
	  driver.get("https://www.etsy.com");
	  Thread.sleep(2000);
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  for(WebElement link: links) {
		  if (link.isDisplayed())
		  System.out.println(link.getText());
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
