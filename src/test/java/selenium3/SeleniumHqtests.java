package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHqtests {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://www.seleniumhq.org");
		String a = driver.getTitle();
		System.out.println(a.equals("Selenium - Web Browser Automation") ? "Pass" : "Fail");
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Projects")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Selenium WebDriver")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Download Selenium")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("q")).sendKeys("Cucumber Java");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(2000);// very important - otherwise it will be to fast and will not wait until results are loaded
		
		//Print search results from Google
		String result = driver.findElement(By.id("resInfo-0")).getText(); // getText() helps us read text from visible elements on a webpage
		System.out.println(result);
		
		driver.close();
		
	}
}
