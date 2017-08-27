package selenium8;

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class DateComparison {
	WebDriver driver;
	static String todaysDate;
	static String dateunified1;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test (priority = 0)
	public void getDateFromGoogle() throws InterruptedException {
		driver.get("http://www.google.com/");
		driver.findElement(By.id("lst-ib")).sendKeys("today's date" + Keys.ENTER);
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals("today's date - Google Search", title);
		String dateGoogle = driver.findElement(By.xpath("//div[@class = 'vk_bk vk_ans']")).getText();
		String dateGoogleDayOfWeek = dateGoogle.substring(0, 6);
		dateGoogle = dateGoogle.substring(8);
		System.out.println(dateGoogle);
		System.out.println(dateGoogleDayOfWeek);
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		LocalDate d1 = LocalDate.parse(dateGoogle, dtf1);
		DateComparison.dateunified1 = dateGoogleDayOfWeek + d1;
		System.out.println(dateunified1);
	}
	
	@Test (priority = 5)
	public void calendarDate() {
		driver.get("https://www.calendardate.com/");
		String date1 = driver.findElement(By.xpath("//header/div")).getText();
		date1 = date1.substring(date1.indexOf("8") + 1);
		String date1DayOfWeek = date1.substring(1, 4);
		String date1Date = date1.substring(5);
	
		switch (date1DayOfWeek) {
			case "Mon":
				date1DayOfWeek = "Monday"; break;
			case "Tue":
				date1DayOfWeek = "Tuesday"; break;
			case "Wed":
				date1DayOfWeek = "Wednesday"; break;
			case "Thu":
				date1DayOfWeek = "Thursday"; break;
			case "Fri":
				date1DayOfWeek = "Friday"; break;
			case "Sat":
				date1DayOfWeek = "Saturday"; break;
			case "Sun":
				date1DayOfWeek = "Sunday"; break;
		}
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		LocalDate d2 = LocalDate.parse(date1Date, dtf2);
		String dateunified2 = date1DayOfWeek + d2;
		
	    Assert.assertEquals(dateunified1, dateunified2);
		System.out.println(dateunified2);
		System.out.println(d2);
		driver.quit();
	}

}
