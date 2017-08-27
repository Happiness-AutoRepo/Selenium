package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SecondItem {
	WebDriver driver;

	public SecondItem(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "quantity_wanted")
	public static WebElement secondItemQuantity;
	
	public static void changeQuantity() {
		secondItemQuantity.clear();
		secondItemQuantity.sendKeys("2");
	}
	
	@FindBy(id = "group_1")
	public static WebElement dropdown;
	
	public static void changeSize() {
		Select select = new Select(dropdown);
		select.selectByIndex(2);
	}
	
	@FindBy(css = "#add_to_cart button")
	public static WebElement addToCart;
	
	public static void addSecondItemToCart() {
		addToCart.click();
	}
	
	@FindBy(partialLinkText = "Proceed to checkout")
	public static WebElement checkout;
	
	public static void clickProceedToCheckout() {
		checkout.click();
	}
}


//