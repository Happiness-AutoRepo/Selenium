package selenium8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	WebDriver driver;

  @BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

	@Test(priority = 0)
	public void testing() {
		driver.get("https://www.google.com");
		String a = driver.findElement(By.id("lst-ib")).getAttribute("spellcheck");
		System.out.println(a);
	}

	@Test(priority = 1)
	public void testing2() {
		driver.get("https://www.google.com");
		String a = driver.findElement(By.id("lst-ib")).getAttribute("spellcheck");
		System.out.println(a);
	}

  @AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
  }

}
