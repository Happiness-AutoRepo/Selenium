package selenium5;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkBoxTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 0)
	public void checkBoxTest() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		WebElement ch1 = driver.findElement(By.xpath("//input[@type ='checkbox' ][1]"));
		WebElement ch2 = driver.findElement(By.xpath("//input[@type ='checkbox' ][2]"));
		
		print(ch1, ch2);
		
		ch1.click();
		
		print(ch1, ch2);
	}
	
	@Test(priority = 1)
	public void changeState() {
		WebElement ch1 = driver.findElement(By.xpath("//input[@type ='checkbox' ][1]"));
		
		toggle(ch1,false);
		assertFalse(ch1.isSelected());
		toggle(ch1,true);
		assertTrue(ch1.isSelected());
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public void toggle(WebElement checkbox, boolean checked) {
		if(checked) {
			if(checkbox.isSelected()) {
				return;
			}else {
				checkbox.click();
			}
		}else {
			if (checkbox.isSelected()) {
				checkbox.click();
			}else {
				return;
			}
		}
			
		
	}

	public void print(WebElement ch1, WebElement ch2) {
		System.out.println("-----------------------------");
		System.out.println("Is checkbox 1 selected?");
		System.out.println(ch1.isSelected());
		System.out.println("Is checkbox 2 selected?");
		System.out.println(ch2.isSelected());
	}
	
	
}
