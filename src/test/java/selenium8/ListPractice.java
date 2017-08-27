package selenium8;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ListPractice {
  
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void checkboxes() {
	  driver.get("http://automationpractice.com");
	  driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();
	  
	  List <WebElement> checkbuttons = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
	  System.out.println(checkbuttons.size());
	  
		for (WebElement webElement : checkbuttons) {
		  webElement.click();

			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(false);
			softassert.assertAll();
	} 
  }
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.quit();
  }

}
