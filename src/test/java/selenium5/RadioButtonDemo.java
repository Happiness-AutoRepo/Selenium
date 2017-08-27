package selenium5;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonDemo {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void hotwireTest() {
		driver.get("http://www.hotwire.com/");
		
		//WebElement is a class that holds elements from the page
		
		WebElement hotel = driver.findElement(By.id("hoteloption"));
		WebElement cars = driver.findElement(By.id("caroption")) ;
		WebElement flights = driver.findElement(By.id("flightoption"));
		
		printWhatsSelected(hotel, cars, flights); // right click -- refactor -- extract method(encapsulate your code into method so it's reusable)
		assertTrue(hotel.isSelected()); // calling assert statically too, asserting that hotel is selected.
		
		cars.click(); // clicking on cars, so hotels should uncheck;
		
		printWhatsSelected(hotel, cars, flights); // invoking print method again
		
		driver.quit();
		
	}

	public void printWhatsSelected(WebElement hotel, WebElement cars, WebElement flights) {
		System.out.println("---------------------------");
		System.out.println("Is hotel selected?");
		System.out.println(hotel.isSelected());
		System.out.println("Is cars selected?");
		System.out.println(cars.isSelected());
		System.out.println("Is flights selected?");
		System.out.println(flights.isSelected());
	}
}
