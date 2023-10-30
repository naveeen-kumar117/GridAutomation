package com.flight.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Billing_address {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id = "input_53_addr_line1")
	private WebElement house_address;
	
	@FindBy(id = "input_53_addr_line2")
	private WebElement street_address;
	
	@FindBy(id = "input_53_city")
	private WebElement city;
	
	@FindBy(id = "input_53_state")
	private WebElement state;
	
	@FindBy(id = "input_53_postal")
	private WebElement pincode;
	
	@FindBy(id = "buyFlights")
	private WebElement confirm;
	
	
	public Billing_address(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		PageFactory.initElements(driver, this);

	}
	
	public void address(String house, String street, String city, String state, String pincode) {
		
		this.wait.until(ExpectedConditions.visibilityOf(this.house_address));
		
		this.house_address.sendKeys(house);
		this.street_address.sendKeys(street);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.pincode.sendKeys(pincode);
		
		this.confirm.click();
	}

}
