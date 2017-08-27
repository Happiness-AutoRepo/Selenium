package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.Google.com");

		Thread.sleep(2000);

		int a = 0;
		int b = 1;

		for (int i = 0; i < 100; i++) {
			
			a = a + 1;
			
			String search = a + "+" + b;
			
			driver.findElement(By.id("lst-ib")).clear();

			driver.findElement(By.id("lst-ib")).sendKeys(search + Keys.ENTER);

			Thread.sleep(2000);

			String result = driver.findElement(By.id("cwos")).getText();

			Thread.sleep(2000);

			System.out.println(result);

			//driver.close();
		}
	}

}
