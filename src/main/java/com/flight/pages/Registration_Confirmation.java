package com.flight.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration_Confirmation {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(partialLinkText = "sign-in ")
	private WebElement signin;
	
	@FindBy(linkText = "Flights")
	private WebElement flights;
	
	public Registration_Confirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		System.out.println("Registration confirm page");
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		PageFactory.initElements(driver, this);
	}
	
	public void goToFlight() {
		//this.wait.until(ExpectedConditions.visibilityOf(this.signin));
		
		this.flights.click();
		
		
	}
	
	

}
