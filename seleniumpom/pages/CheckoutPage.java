package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public static String deliveryAddressString;
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//p[@class = 'product-name'])[2]")
	public static WebElement productName;
	
	public static String getName() {
		return productName.getText();
	}
	
	@FindBy(css = "td.cart_unit span.price span")
	public static WebElement productPrice;
	
	public static String getPrice() {
		return productPrice.getText();
	}
	
	@FindBy(css = "td.cart_quantity input")
	public static WebElement quantity;
	
	public static String getQuantity() {
		return quantity.getAttribute("value");
	}
	
	@FindBy(css = "#total_price")
	public static WebElement totalPrice;
	
	public static String getTotalPrice() {
		return totalPrice.getText();
	}
	
	@FindBy(xpath = "//ul[@class = 'address first_item item box']")
	public static WebElement deliveryAddress;
	
	public static String getDeliveryAddress() {
		deliveryAddressString = deliveryAddress.getText().substring(29).trim();
		return deliveryAddressString;
	}
	
	@FindBy(xpath = "//ul[@class = 'address last_item alternate_item box']")
	public static WebElement invoiceAddress;
	
	public static String getInvoiceAddress() {
		return invoiceAddress.getText().substring(29).trim();
	}
	
	@FindBy(linkText = "Sheldon Cooper")
	public static WebElement accountHolder1;
	
	public static void pressOnAccountHolderName1() {
		accountHolder1.click();
	}
	
	@FindBy(linkText = "Amy Fowler")
	public static WebElement accountHolder2;
	
	public static void pressOnAccountHolderName2() {
		accountHolder2.click();
	}
}




