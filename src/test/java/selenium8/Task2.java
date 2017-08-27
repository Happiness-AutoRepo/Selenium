package selenium8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Getting to the website and adding a user
		driver.get("http://thedemosite.co.uk/index.php");
		driver.findElement(By.linkText("3. Add a User")).click();;
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John" + Keys.TAB + "12345678");
		driver.findElement(By.xpath("//input[@name='FormsButton2']")).click();
		
		// Logging in 
		driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John" + Keys.TAB + "12345678" + Keys.ENTER);
		driver.findElement(By.xpath("//input[@value='Test Login']")).click();
		
		// Verifying we are logged in
		boolean success = driver.findElement(By.xpath("//b[.='**Successful Login**']")).isDisplayed();
		if (success)
			System.out.println("1. Successful login");
		else
			System.out.println("1. Couldn't login");
		
		// Closing the browser
		driver.close();
		System.out.println("2. Browser is closed");
	}

}
