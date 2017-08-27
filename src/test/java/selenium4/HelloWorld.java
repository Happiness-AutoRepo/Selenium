package selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class HelloWorld {
	WebDriver driver;
	@BeforeTest
	public void beforeAnyTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");

	}

//	 @Test // annotation start with @ and always placed on top of method. Program won't run without annotation.
//	 public void sayHello1() {
//	 driver = new ChromeDriver();
//	 driver.get("http://www.google.com");
//	 driver.manage().window().maximize();
//	 driver.quit();
//	
//	 }
	 @Test
	 public void sayHello2() {
	 driver = new ChromeDriver();
	 driver.get("http://www.etsy.com");
	 
	 Assert.assertEquals(10, 1);
	 
	 driver.quit();
	 }

	@Test
	public void sayHello3() throws InterruptedException {
		
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // must go after driver declaration
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("lst-ib")).sendKeys("Memorial Day" + Keys.ENTER);
	Assert.assertTrue(200 == 250);
	Thread.sleep(5000);
	driver.quit();						
			
	}
//	@AfterTest
//	public void a() {
//		driver.quit();
//	}
}

