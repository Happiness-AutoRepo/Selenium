package selenium4;
/*
 * 
 * This is Task3 Homework separated into different annotations
 */
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PhpTestNG {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void negativeLogin() {
		driver.get("http://www.phptravels.net/");
		driver.findElement(By.xpath("//li[@class='<!--pull-right--> width_change']")).click();
		driver.findElement(By.xpath("//a[@href='http://www.phptravels.net/login']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-action btn-block loginbtn']")).click();
		boolean isInvalid = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).isDisplayed();
		Assert.assertTrue(isInvalid);
	}

	@Test(priority = 0) // this annotation will execute first because priority is 0
	public void positiveLogin() {
		driver.get("http://www.phptravels.net/");
		driver.findElement(By.xpath("//li[@class='<!--pull-right--> width_change']")).click();
		driver.findElement(By.xpath("//a[@href='http://www.phptravels.net/login']")).click();
		driver.findElement(By.xpath("//input[@class='form-control padding-10']")).sendKeys("user@phptravels.com" + Keys.TAB + "demouser" + Keys.ENTER);
		boolean greeting = driver.findElement(By.xpath("//h3[@class='RTL']")).isDisplayed();
		Assert.assertTrue(greeting);
		
		driver.quit();
	}

}
