package selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.amazon.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.get("https://www.etsy.com");
		System.out.println(driver.getTitle());
		//2 sec to wait before the next action
		Thread.sleep(2000);
		//refresh
		driver.navigate().refresh();
		
		//Navigate back
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().forward();
		
		//close browser
		driver.close(); // will close only the current tab
		//or driver.quit(); - will close the browser
	}
}
