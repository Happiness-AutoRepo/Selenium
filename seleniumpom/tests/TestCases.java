package tests;

import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LogInPage;
import pages.MyAccount;
import pages.MyAddresses;
import pages.SecondItem;

import static pages.HomePage.*;
import static pages.LogInPage.*;
import static org.testng.Assert.assertEquals;
import static pages.CheckoutPage.*;
import static pages.MyAccount.*;
import static pages.MyAddresses.*;
import static pages.SecondItem.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestCases {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/");
		//driver.manage().window().maximize();
		
		HomePage homePage = new HomePage(driver);
		LogInPage logInPage = new LogInPage(driver);
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		MyAccount myAccount = new MyAccount(driver);
		MyAddresses myAddresses = new MyAddresses(driver);
		SecondItem secondItem = new SecondItem(driver);
	}
	
	@Test(priority = 0)
	public void testCase1() {
		
		pressSignIn();
		typeEmail1();
		typePassword();
		clickOnMainLogo();
		addFirstItemToCart();
		proceedToCheckout();
		
		assertEquals(getName(), "Faded Short Sleeve T-shirts");
		assertEquals(getPrice(), "$16.51");
		assertEquals(getQuantity(), "1");
		assertEquals(getTotalPrice(), "$19.25");
		assertEquals(getDeliveryAddress(), getInvoiceAddress());
		
		pressOnAccountHolderName1();
		pressMyAddresses();
		
		assertEquals(getMyAddress(), deliveryAddressString);		
	}
	
	@Test(priority = 1)
	public void testCase2() {
		
		pressSignIn();
		typeEmail2();
		typePassword();
		clickOnMainLogo();
		clickOnSecondItem();
		changeQuantity();
		changeSize();
		addSecondItemToCart();
		clickProceedToCheckout();
		
		assertEquals(getName(), "Blouse");
		assertEquals(getPrice(), "$27.00");
		assertEquals(getQuantity(), "2");
		assertEquals(getTotalPrice(), "$58.24");
		assertEquals(getDeliveryAddress(), getInvoiceAddress());
		
		pressOnAccountHolderName2();
		pressMyAddresses();
		
		assertEquals(getMyAddress(), deliveryAddressString);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
