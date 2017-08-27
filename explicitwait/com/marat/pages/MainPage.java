package com.marat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span.start-text")
	public WebElement goButton;
	
	@FindBy(css = "canvas.gauge-speed-text")
	public WebElement speedWindow;
	
	@FindBy(css = "span[class *= 'download-speed']")
	public WebElement downloadResult;
	
	@FindBy(css = "span[class *= 'upload-speed']")
	public WebElement uploadResult;
}












