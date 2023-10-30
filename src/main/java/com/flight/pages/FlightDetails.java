package com.flight.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetails {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id = "passCount")
	private WebElement passenger_count;
	
	@FindBy(name = "fromPort")
	private WebElement departing_from;
	
	@FindBy(name="fromMonth")
	private WebElement from_month;
	
	@FindBy(name="fromDay")
	private WebElement from_day;
	
	@FindBy(name="toPort")
	private WebElement destination;
	
	@FindBy(name="toMonth")
	private WebElement to_month;
	
	@FindBy(name="toDay")
	private WebElement to_day;
	
	@FindBy(name="airline")
	private WebElement airline;
	
	@FindBy(id="findFlights")
	private WebElement confirmation;
	

	
	public FlightDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		PageFactory.initElements(driver, this);
	}
	
	public void flight_Details(String count,String boarding, String b_month, String b_date, String dest, String d_month, String d_day, String airline) {
		
		this.wait.until(ExpectedConditions.visibilityOf(this.passenger_count));
		
		Select passenger = new Select(this.passenger_count);
		passenger.selectByVisibleText(count);
		
		Select departing = new Select(this.departing_from);
		departing.selectByVisibleText(boarding);
		
		Select f_month = new Select(this.from_month);
		f_month.selectByVisibleText(b_month);
		Select f_day = new Select(from_day);
		f_day.selectByVisibleText(b_date);
		Select destination = new Select(this.destination);
		destination.selectByVisibleText(dest);
		
		Select to_month = new Select(this.to_month);
		to_month.selectByVisibleText(d_month);
		Select to_day = new Select(this.to_day);
		to_day.selectByVisibleText(d_day);
		
		Select air = new Select(this.airline);
		air.selectByVisibleText(airline);
		
		this.confirmation.click();
		
	}
	

	
	
}
