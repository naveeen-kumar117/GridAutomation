package com.flight.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment_Details {
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"confirm-table\"]/tbody/tr[1]/td[1]/font")
	private WebElement bill_id;
	
	@FindBy(xpath = "//*[@id=\"confirm-table\"]/tbody/tr[2]/td[2]/font")
	private WebElement tax;
	
	@FindBy(xpath = "//*[@id=\"confirm-table\"]/tbody/tr[3]/td[2]/font")
	private WebElement total;
	
	@FindBy(id = "sign-on")
	private WebElement signoff;
	
	
	public Payment_Details(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		PageFactory.initElements(driver, this);
	}
	

	public String bill() {
		
		//this.wait.until(ExpectedConditions.visibilityOf(this.bill_id));
		
		System.out.println("Check the below details for your Journey:");
		System.out.println("-------------------------------------------");
		
		System.out.println("Flight Booking ID: "+this.bill_id.getText());
		System.out.println("Tax Payable: "+this.tax.getText());
		System.out.println("Total Bill: "+this.total.getText());
		
		this.signoff.click();
		
		return this.total.getText();
		
	}
	
	
}
