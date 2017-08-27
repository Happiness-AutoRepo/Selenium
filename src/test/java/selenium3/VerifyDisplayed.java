package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyDisplayed {

	public static void main(String[] args) throws InterruptedException {

		String url = "http://newtours.demoaut.com/";
		String userName = "tutorial";
		String password = "tutorial";

		System.setProperty("webdriver.chrome.driver","C:/Users/Marat Metoff/Documents/Libraries/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		for (int i = 0; i < 10; i++) {
			driver.get(url);
			System.out.println(driver.findElement(By.linkText("SIGN-ON")).isDisplayed() ? "Sign-on displayed" : "Sign-on is not displayed");
			System.out.println(driver.findElement(By.linkText("REGISTER")).isDisplayed() ? "Register displayed" : "Register is not displayed");
			System.out.println(driver.findElement(By.xpath("//a[.='SUPPORT']")).isDisplayed() ? "Support displayed" : "Support is not displayed");
			System.out.println(driver.findElement(By.xpath("//a[.='CONTACT']")).isDisplayed() ? "Contact displayed" : "Contact is not displayed");

			driver.findElement(By.linkText("CONTACT")).click();

			Thread.sleep(2000);

			System.out.println(driver.findElement(By.xpath("//img[@src ='/images/forms/home.gif']")).isDisplayed() ? "Back to home button displayed" : "Back to home button is not displayed");
			driver.findElement(By.xpath("//img[@src ='/images/forms/home.gif']")).click();

			Thread.sleep(2000);

			//driver.quit();
		}

	}

}
