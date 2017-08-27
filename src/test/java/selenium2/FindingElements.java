package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 1. Go to amazon.com
 * 2. Search for wooden spoon
 * 3. Verify title contains "wooden spoon" 
 * @author Marat Metoff
 *
 */

public class FindingElements {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		
		driver.get("http://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon"); //going to a page and find an element that has an id "twotabsearchtextbox" (WHERE), and sending keys (WHAT)
		driver.findElement(By.className("nav-input")).click();
		
		String title = driver.getTitle();
		System.out.println(title.contains("wooden spoon") ? "Verified" : "Failed"); //verifying if title contains "wooden spoon"
		driver.quit();
		
	}

}
