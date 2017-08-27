package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddresses {
	WebDriver driver;

	public MyAddresses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "ul.last_item")
	public static WebElement myAddress;
	
	public static String getMyAddress() {
		return myAddress.getText().substring(11,87).trim();
	}
}
