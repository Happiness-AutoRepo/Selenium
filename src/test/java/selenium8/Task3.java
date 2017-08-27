package selenium8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Application will wait for up to 10 seconds for html code to load

		// Getting to the website and and navigating to Login screen
		driver.get("http://www.phptravels.net/");
		driver.findElement(By.xpath("//li[@class='<!--pull-right--> width_change']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='http://www.phptravels.net/login']")).click();
		//Thread.sleep(2000);
		
		// Logging in without credentials
		driver.findElement(By.xpath("//button[@class='btn btn-action btn-block loginbtn']")).click();
		//Thread.sleep(2000);
		boolean isInvalid = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).isDisplayed();
		if (isInvalid)
			System.out.println("1. Unsuccessful Login message is displayed");
		else
			System.out.println("1. Unsuccessful Login message is not displayed");
		//Thread.sleep(2000);
		
		// Logging in with credentials
		driver.findElement(By.xpath("//input[@class='form-control padding-10']")).sendKeys("user@phptravels.com" + Keys.TAB + "demouser" + Keys.ENTER);
		//Thread.sleep(2000);
		boolean greeting = driver.findElement(By.xpath("//h3[@class='RTL']")).isDisplayed();
		if (greeting)
			System.out.println("2. Greeting message is displayed");
		else
			System.out.println("2. Login unsuccessful");
		
		// Clicking on John
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='pull-right width_change']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='http://www.phptravels.net/account/logout/']")).click();
		//Thread.sleep(2000);
		
		// Logging out and closing the browser
		System.out.println("3. Successfully Logged out");
		driver.close();
		System.out.println("4. Browser has been closed");
		
		

	}

}
