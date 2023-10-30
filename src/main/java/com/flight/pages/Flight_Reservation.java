package com.flight.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flight_Reservation {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "input_50_0_0")
	private WebElement flight_departure;

	@FindBy(xpath = "/html/body/form/div[1]/ul/li[7]/div/table[2]/tbody/tr[2]/td[1]/input")
	private WebElement flight_return;

	@FindBy(id = "reserveFlights")
	private WebElement reserve;

	public Flight_Reservation(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		PageFactory.initElements(driver, this);

	}

	public void flight_select() {
		this.wait.until(ExpectedConditions.visibilityOf(this.flight_departure));
		this.flight_departure.click();
		this.flight_return.click();
		this.reserve.click();
	}

}
