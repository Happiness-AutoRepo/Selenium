package selenium8;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MercuryToursRegression {
  
  WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
	
  @Test
  public void MT001() throws InterruptedException {
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  WebElement userName = driver.findElement(By.xpath("//input[@name = 'userName']"));
	  userName.sendKeys("tutorial" + Keys.TAB + "tutorial" + Keys.ENTER);
	  
	  String url = driver.getCurrentUrl();
	  if (url.contains("?")) {
		  url = url.substring(0, url.indexOf("?"));
	  }
	  Assert.assertEquals("http://newtours.demoaut.com/mercuryreservation.php",url);
	  Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
  }
  
  @Test
  public void MT002() {
	  driver.get("http://newtours.demoaut.com/");
	  WebElement userName = driver.findElement(By.xpath("//input[@name = 'userName']"));
	  userName.sendKeys("tutorial" + Keys.TAB + "tutorial" + Keys.ENTER);
	  
	  // Inputting the information
	  WebElement passDropdown = driver.findElement(By.xpath("//select[@name='passCount']"));
	  Select passSelect = new Select(passDropdown);
	  passSelect.selectByIndex(1);
	  
	  WebElement cityDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
	  Select citySelect = new Select(cityDropdown);
	  citySelect.selectByIndex(4);
	  
	  WebElement monthDropdown = driver.findElement(By.xpath("//select[@name='fromMonth']"));
	  Select monthSelect = new Select(monthDropdown);
	  monthSelect.selectByIndex(11);
	  
	  WebElement dayDropdown = driver.findElement(By.xpath("//select[@name='fromDay']"));
	  Select daySelect = new Select(dayDropdown);
	  daySelect.selectByIndex(23);
	  
	  WebElement returnCityDropdown = driver.findElement(By.xpath("//select[@name='toPort']"));
	  Select returnCitySelect = new Select(returnCityDropdown);
	  returnCitySelect.selectByIndex(7);
	  
	  WebElement returnMonthDropdown = driver.findElement(By.xpath("//select[@name='toMonth']"));
	  Select returnMonthSelect = new Select(returnMonthDropdown);
	  returnMonthSelect.selectByIndex(11);
	  
	  WebElement returnDayDropdown = driver.findElement(By.xpath("//select[@name='toDay']"));
	  Select returnDaySelect = new Select(returnDayDropdown);
	  returnDaySelect.selectByIndex(29);
	  
	  WebElement businessRadio = driver.findElement(By.xpath("//input[@value='Business']"));
	  businessRadio.click();
	  
	  WebElement airlineDropdown = driver.findElement(By.xpath("//select[@name='airline']"));
	  Select airlineSelect = new Select(airlineDropdown);
	  airlineSelect.selectByIndex(2);
	  
	  //==================== Verifying the data ==========================
	  WebElement roundtrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));
	  Assert.assertTrue(roundtrip.isSelected());
	  
	  WebElement cityDropdownParis = driver.findElement(By.xpath("//select[@name='fromPort']/option[5]"));
	  Assert.assertTrue(cityDropdownParis.isSelected());
	  
	  WebElement monthDropdownDecember = driver.findElement(By.xpath("//select[@name='fromMonth']/option[12]"));
	  Assert.assertTrue(monthDropdownDecember.isSelected());
	  
	  WebElement dayDropdown24 = driver.findElement(By.xpath("//select[@name='fromDay']/option[24]"));
	  Assert.assertTrue(dayDropdown24.isSelected());
	  
	  WebElement returnCityDropdownSeattle = driver.findElement(By.xpath("//select[@name='toPort']/option[8]"));
	  Assert.assertTrue(returnCityDropdownSeattle.isSelected());
	  
	  
	  WebElement returnMonthDropdownDecember = driver.findElement(By.xpath("//select[@name='toMonth']/option[12]"));
	  Assert.assertTrue(returnMonthDropdownDecember.isSelected());
	  
	  WebElement returnDayDropdown30 = driver.findElement(By.xpath("//select[@name='toDay']/option[30]"));
	  Assert.assertTrue(returnDayDropdown30.isSelected());
	  
	  Assert.assertTrue(businessRadio.isSelected());
	  
	  WebElement airlineDropdownUnified = driver.findElement(By.xpath("//select[@name='airline']/option[3]"));
	  Assert.assertTrue(airlineDropdownUnified.isSelected());

	  //============ Clicking Continue and verifying URL and Title =====================
	  driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	  String url002 = driver.getCurrentUrl();
	  String title002 = driver.getTitle();
	  Assert.assertEquals("http://newtours.demoaut.com/mercuryreservation2.php", url002);
	  Assert.assertEquals("Select a Flight: Mercury Tours", title002);  
  }
  
  @Test
  public void MT003() {
	  //================== Booking a flight ====================
	  driver.findElement(By.xpath("//input[@value = 'Unified Airlines$363$281$11:24']")).click();
	  driver.findElement(By.xpath("//input[@value = 'Unified Airlines$633$303$18:44']")).click();
	  driver.findElement(By.xpath("//input[@name = 'reserveFlights']")).click();
	  String url003 = driver.getCurrentUrl();
	  String title003 = driver.getTitle();
	  Assert.assertEquals("http://newtours.demoaut.com/mercurypurchase.php", url003);
	  Assert.assertEquals("Book a Flight: Mercury Tours", title003);
  }
  
  @Test
  public void MT004() {
	  //=========== Filling the fields and verifying them ================
	  driver.findElement(By.xpath("//input[@name = 'passFirst0']")).sendKeys("John" + Keys.TAB + "Smith");
	  WebElement meal = driver.findElement(By.xpath("//select[@name = 'pass.0.meal']"));
	  Select mealDropdown = new Select(meal);
	  mealDropdown.selectByIndex(9);
	  
	  WebElement cc = driver.findElement(By.xpath("//select[@name = 'creditCard']"));
	  Select ccDropdown = new Select(cc);
	  ccDropdown.selectByIndex(2);
	  
	  cc.sendKeys(Keys.TAB + "4111111111111111");
	  
	  WebElement expMonth = driver.findElement(By.xpath("//select[@name = 'cc_exp_dt_mn']"));
	  Select expMonthDropdown = new Select(expMonth);
	  expMonthDropdown.selectByIndex(12);
	  
	  WebElement expYear = driver.findElement(By.xpath("//select[@name = 'cc_exp_dt_yr']"));
	  Select expYearDropdown = new Select(expYear);
	  expYearDropdown.selectByIndex(11);
	  
	  expYear.sendKeys(Keys.TAB + "John" + Keys.TAB + "Smith");
	  
	  WebElement address = driver.findElement(By.xpath("//input[@name = 'billAddress1']"));
	  address.clear();
	  address.sendKeys("7921 Jonas Branch Dr");
	  
	  WebElement city = driver.findElement(By.xpath("//input[@name = 'billCity']"));
	  city.clear();
	  city.sendKeys("McLean");
	  
	  WebElement state = driver.findElement(By.xpath("//input[@name = 'billState']"));
	  state.clear();
	  state.sendKeys("VA");
	  
	  WebElement zip = driver.findElement(By.xpath("//input[@name = 'billZip']"));
	  zip.clear();
	  zip.sendKeys("22102");
	  
	  driver.findElement(By.xpath("//tr[@bgcolor = '#CCCCCC'][2]/td[@align]/input")).click();
	  
	  //================= Verification =======================
	  
	  //================= Securing Purchase ==================
	  
	  driver.findElement(By.xpath("//input[@name = 'buyFlights']")).click();
	  String url004 = driver.getCurrentUrl();
	  String title004 = driver.getTitle();
	  
	  Assert.assertEquals("http://newtours.demoaut.com/mercurypurchase2.php", url004);
	  Assert.assertEquals("Flight Confirmation: Mercury Tours", title004);
  }
  
  @Test
  public void MT005() {
	  //================ Verifying information ==================  
	 WebElement message = driver.findElement(By.xpath("//b/font[@size = '+1']"));
	 Assert.assertEquals("Your itinerary has been booked!",message.getText());
	 
	 WebElement ticket = driver.findElement(By.xpath("//b/font[@color = '#FFFFFF']"));
	 Assert.assertTrue(ticket.isDisplayed());

  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
