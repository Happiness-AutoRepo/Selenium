package selenium8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ctrl+F - opens search window in Chrome
 * @author Marat Metoff
 *
 */

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Verifying Title
		String storeUrl = "Welcome: Mercury Tours";
		driver.get("http://newtours.demoaut.com/");
		
		if (storeUrl.equals(driver.getTitle()))
			System.out.println("1. Title verified");
		else
			System.out.println("1. Title verification failed");
		
		// Verifying Date
		String dateWeb = driver.findElement(By.xpath("//b[.='May 27, 2017']")).getText();
		String dateNow = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)); 
		
		if (dateWeb.equals(dateNow))
			System.out.println("2. Date is correct");
		else 
			System.out.println("2. Date is wrong");
		
		
		// Registering
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Doe");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("703-703-703");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("johndoe@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("1 Main St");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("apt 809");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Fairfax");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("VA");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("22033");
		driver.findElement(By.id("email")).sendKeys("John");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("12345678");
		
		driver.findElement(By.xpath("//input[@name='register']")).click();
		
		// Verifying username
		String john =  "Note: Your user name is John.";
		String message = driver.findElement(By.xpath("//b[contains(text(),'Note')]")).getText();
		if (john.equals(message))
			System.out.println("3. User name is correct after registration");
		else
			System.out.println("3. User name is wrong after registartion");
		
		// Verifying sign in fields are displayed
		driver.findElement(By.linkText("sign-in")).click();
		boolean userName = driver.findElement(By.xpath("//b[contains(text(),'User')]")).isDisplayed();
		boolean password = driver.findElement(By.xpath("//b[contains(text(),'Password:')]")).isDisplayed();
		boolean submit = driver.findElement(By.xpath("//input[@name='login']")).isDisplayed();
		if (userName && password && submit)
			System.out.println("4. All sign-in elements are displayed");
		else
			System.out.println("4. Some elements are missing");
		
		// Signing in(Our credentials don't work - using 123) 
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("123" + Keys.TAB + "123" + Keys.ENTER);
		/*driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@name='login']")).click(); - redundant */
		
		
		// Verifying we are logged in
		String title = "Find a Flight: Mercury Tours:";
		if (title.equals(driver.getTitle()))
			System.out.println("5. Successfully logged in");
		else
			System.out.println("5. Log in unsuccessfull");
		
		// Signing off and closing the browser
		driver.findElement(By.linkText("SIGN-OFF")).click();
		driver.close();
		System.out.println("6. Browser is closed");

	}

}
