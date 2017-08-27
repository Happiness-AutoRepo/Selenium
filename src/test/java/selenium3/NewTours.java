package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "http://newtours.demoaut.com/" ;
		String userName = "tutorial";
		String password = "tutorial";
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(2000);
		
		//check title;
		//check flight finder image;
		//check flight details text.
		
		TITLE: if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
			      System.out.println("Title check passed");
		       else
			      System.out.println("Title check failed");
		
		boolean imageDisplayed = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).isDisplayed(); // absolute xPath (right click - copy xPath)
		boolean imageDisplayedRelative = driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed(); // relative xPath double slash img[@src = ''];
		System.out.println(imageDisplayedRelative);
		
		IMAGE: if(imageDisplayed)
			      System.out.println("Image check passed");
		       else
			      System.out.println("Image check failed");
		
		boolean FlightDetails = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")).isDisplayed();
		boolean FlightDetailsRelative = driver.findElement(By.xpath("//font[.='Preferences']")).isDisplayed();
		System.out.println(FlightDetailsRelative);
		
		IMAGE2: if(FlightDetails)
		      System.out.println("Image 2 check passed");
	       else
		      System.out.println("Image 2 check failed");
		
		driver.close();

	}

}
