package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	public static WebElement email;
	
	public static void typeEmail1() {
		email.sendKeys("testuserone@ipdeer.com");
	}
	
	public static void typeEmail2() {
		email.sendKeys("testusertwo@ipdeer.com");
	}
	
	@FindBy(id = "passwd")
	public static WebElement password;
	
	public static void typePassword() {
		String pressSignIn = Keys.chord(Keys.TAB, Keys.TAB, Keys.ENTER);
		password.sendKeys("password" + pressSignIn);
	} 
}
