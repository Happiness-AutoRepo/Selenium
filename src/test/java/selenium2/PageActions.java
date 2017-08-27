package selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * checking if the web page title matches expected title, getting page source and URL
 * @author Marat Metoff
 *
 */
public class PageActions {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.amazon.com");
		System.out.println(driver.getTitle().equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more") ? "Title matches for Amazon" : "Title doesn't match for Amazon");
		System.out.println(driver.getCurrentUrl());
		
		driver.get("http://www.etsy.com");
		System.out.println(driver.getTitle()); //print CURRENT title
		
		//print current URL
		System.out.println(driver.getCurrentUrl());
		
		//navigate directly to a particular search
		driver.navigate().to("https://www.etsy.com/search?q=wooden%20spoon");
		//change "wooden spoon" to "leather jacket"
		driver.navigate().to("https://www.etsy.com/search?q=leather%20jacket");
		
		//get page source
		driver.get("http://www.hotwire.com");
		String html = driver.getPageSource();
		//System.out.println(html); omitted so we can see first 100 characters
		
		//print first 100 characters of html code, plus length
		System.out.println(html.substring(0,100));
		System.out.println("length: " + html.length());
		
		//checking if particular content is present in html code
		driver.get("http://www.ebay.com");
		html = driver.getPageSource();
		if(html.contains("Popular Destinations")) {
			System.out.println("Popular Destination is present");
		}else
			System.out.println("Popular Destination is not present");
		
	}

}
