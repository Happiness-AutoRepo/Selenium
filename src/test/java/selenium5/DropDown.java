package selenium5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DropDown {
 
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}
	
	@Test
    public void dropDownTest() {
		WebElement list = driver.findElement(By.id("dropdown")); // saving the element in the reference variable of type WebElement
		Select dropdownList = new Select(list); // passing the element to a constructor of class Select.
		
		for(WebElement option: dropdownList.getOptions()) { // working with contents of dropdown list: printing all the options
			System.out.println(option.getText());
		}
		
		WebElement chosenOne = dropdownList.getAllSelectedOptions().get(0); // printing currently selected options
		System.out.println("Currently selected: ");
		System.out.println(chosenOne.getText());
		
		System.out.println("Selecting option 1");
		dropdownList.selectByVisibleText("Option 1"); // selecting the option 1
		
		assertEquals("Please select an option",chosenOne.getText());
		
		System.out.println("Selecting the third option"); // selecting by index, indexing here starts from 0
		dropdownList.selectByIndex(2);
		
	}
    
 
	
	
	@AfterTest
    public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
    }

}
