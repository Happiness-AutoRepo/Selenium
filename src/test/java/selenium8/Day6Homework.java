package selenium8;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day6Homework {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void LinkTest() {
		// Getting URL and text
		driver.navigate().to("http://www.tutorialspoint.com/java/");
		List<WebElement> a = driver.findElements(By.tagName("a"));
		for (WebElement webElement : a) {
			System.out.println(webElement.getAttribute("url"));
			System.out.println(webElement.getAttribute("text"));
		}
	}

	@Test(priority = 1)
	public void AmazonTest01() {
		// Getting the price of the first result on the page
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag" + Keys.ENTER);
		WebElement element1 = driver.findElement(By.cssSelector("#result_0 > div > div.a-row.a-spacing-none > div:nth-child(2) > a > span"));
		String s1 = element1.getAttribute("aria-label");
		System.out.println("Price of the first result: " + s1);
		
		// Number of items selected and price verification
		element1.click();
		String s2 = driver.findElement(By.cssSelector("select#quantity option[selected]")).getText();
		System.out.println("Number of items in shopping cart: " + s2);
		assertEquals(s2.substring(0, 1), "1"); 
		
		String s3 = driver.findElement(By.id("priceblock_ourprice")).getText();
		System.out.println("Price after we click on ot: " + s3);
		assertEquals(s3, s1);
		
		// Clicking on "Add to cart" and verifying the message "Added to cart is displayed"
		driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
		String s4 = driver.findElement(By.cssSelector("h1[class = 'a-size-medium a-text-bold']")).getText();
		System.out.println("Message: " + s4);
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(s4, "Added to Cart"); // soft assert just to practice it
		sf.assertAll();
	}

	@Test(priority = 2)
	public void AmazonTest02() {
		// Checkbox adidas
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag" + Keys.ENTER);
		String s1 = driver.findElement(By.xpath("(//h2[@data-attribute])[1]")).getText(); // first line items before clicking "adidas"
		String s2 = driver.findElement(By.xpath("(//h2[@data-attribute])[2]")).getText();
		String s3 = driver.findElement(By.xpath("(//h2[@data-attribute])[3]")).getText();
		driver.findElement(By.cssSelector("input[name='s-ref-checkbox-adidas']")).click(); // check  
		String ss1 = driver.findElement(By.xpath("(//h2[@data-attribute])[1]")).getText(); // first line items after clicking "adidas"
		String ss2 = driver.findElement(By.xpath("(//h2[@data-attribute])[2]")).getText();
		String ss3 = driver.findElement(By.xpath("(//h2[@data-attribute])[3]")).getText();
		assertNotEquals(ss1 + ss2 + ss3, s1 + s2 + s3);                                    // asserting results have changed
		driver.findElement(By.cssSelector("input[name='s-ref-checkbox-adidas']")).click(); // uncheck
		String sss1 = driver.findElement(By.xpath("(//h2[@data-attribute])[1]")).getText(); // first line items after unchecking "adidas"
		String sss2 = driver.findElement(By.xpath("(//h2[@data-attribute])[2]")).getText();
		String sss3 = driver.findElement(By.xpath("(//h2[@data-attribute])[3]")).getText();
		assertEquals(sss1 + sss2 + sss3, s1 + s2 + s3);
	}
	
	@Test(priority = 3)
	public void AmazonTest03() throws InterruptedException {
		// Brand checkboxes
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag" + Keys.ENTER);
		
		List<WebElement> check1 =  driver.findElements(By.xpath("(//ul[@class = 'a-unordered-list a-nostyle a-vertical a-spacing-base'])[6]//li")); // Adding only certain checkboxes to an ArrayList
		
		for (WebElement webElement : check1) {
			assertFalse(webElement.isSelected());                                           // Asserting non of them are checked
		}
		
		driver.findElement(By.xpath("//input[@name = 's-ref-checkbox-adidas']")).click();
		driver.findElement(By.xpath("//input[@name = 's-ref-checkbox-Kate Spade New York']")).click();
		
		List<WebElement> check2 = driver.findElements(By.xpath("(//ul[@class = 'a-unordered-list a-nostyle a-vertical a-spacing-base'])[6]//li")); // Adding only certain checkboxes to an ArrayList
		
		for (WebElement webElement : check2) {
			if (webElement == driver.findElement(By.xpath("(//input[@name = 's-ref-checkbox-adidas'])"))) continue;         // clicking first and last one
			if (webElement == driver.findElement(By.xpath("(//input[@name = 's-ref-checkbox-Kate Spade New York'])"))) continue;
			assertFalse(webElement.isSelected());                                           // Asserting non of them are checked
		}	
	}
	
	@Test(priority = 4)
	public void AmazonTest04() {
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag" + Keys.ENTER);
		driver.findElement(By.xpath("//span[contains(text(),'Top-Handle Handbags')]")).click();  //clicking on "Women's Top-handle..."
		
		List<WebElement> check1 = driver.findElements(By.xpath("(//ul[@class = 'a-unordered-list a-nostyle a-vertical a-spacing-base'])[6]//li//input")); // saving all brand option in ArrayList
		
		String sum1 = "";
		for (WebElement webElement : check1) {                                     // checking if we got the right brands
			sum1 += webElement.getAttribute("name").substring(15);  
		}
		
		driver.get("https://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag" + Keys.ENTER);
		driver.findElement(By.xpath("//h4[contains(text(),'Luggage & Travel Gear')]")).click();
		
		List<WebElement> check2 = driver.findElements(By.xpath("(//ul[@class = 'a-unordered-list a-nostyle a-vertical a-spacing-base'])[6]//li//input"));
		
		String sum2 = "";
		for (WebElement webElement : check2) {
			sum2 += webElement.getAttribute("name").substring(15);
		}
		
		assertNotEquals(sum1,sum2);
	}
	
	@Test(priority = 5)
	public void AmazonTest05() {
		driver.get("https://www.amazon.com");
	 
		Select select1 = new Select(driver.findElement(By.id("searchDropdownBox")));
		int numberOfDepartments = select1.getOptions().size();
		System.out.println("Number of Departments: " + numberOfDepartments);  // Number of departments in dropdown menu 
		
		List<String> a1 = new ArrayList();                          // creating a list of all departments in dropdown
		for (WebElement webElement : select1.getOptions()) {
			a1.add(webElement.getText());
		}
		
		List<WebElement> departmentsOnPage = driver.findElements(By.xpath("//span[@class = 'nav-text']")); // Getting all WebElements of the dept located on the page 
		System.out.println("--------------------------------------");
		
		List<String> a2 = new ArrayList();                               // Converting them to strings
		for (WebElement webElement : departmentsOnPage) {
			a2.add(webElement.getAttribute("innerHTML"));
		}
		System.out.println(a1);
		System.out.println(a2);
		assertTrue(a2.containsAll(a1));  // Page does not contain all departments listed in dropdown menu
	}
	
	
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
