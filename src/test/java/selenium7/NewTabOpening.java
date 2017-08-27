package selenium7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTabOpening {
	

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		
		driver.get("http://newtours.demoaut.com/");
		
		String a = Keys.chord(Keys.CONTROL, Keys.ENTER);                                  // Keys.ENTER and Keys.RETURN both work here
		System.out.println(a);                                                            // prints "???"
		driver.findElement(By.linkText("REGISTER")).sendKeys(a);
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {	
		Thread.sleep(3000);
		driver.quit();
	}

}
