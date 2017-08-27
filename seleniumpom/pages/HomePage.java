package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign in")
	public static WebElement signInLink;
	
	public static void pressSignIn() {
		signInLink.click();
	}
	
	@FindBy(css = "img.logo")
	public static WebElement mainLogo;
	
	public static void clickOnMainLogo() {
		mainLogo.click();
	}
	
	@FindBy(xpath = "(//a[@title = 'Add to cart'])[1]")
	public static WebElement firstItem;
	
	public static void addFirstItemToCart() {
		firstItem.click();
	}
	
	@FindBy(xpath = "(//img[contains(@class, 'replace-2x')])[2]")
	public static WebElement secondItem;
	
	public static void clickOnSecondItem() {
		secondItem.click();
	}
	
	@FindBy(partialLinkText = "Proceed to checkout")
	public static WebElement checkout;
	
	public static void proceedToCheckout() {
		checkout.click();
	}
	//Proceed to checkout
}
