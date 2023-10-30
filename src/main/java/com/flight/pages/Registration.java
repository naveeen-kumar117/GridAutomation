package com.flight.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Registration {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="userName")
	private WebElement email;
	
	@FindBy(name="address1")
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(name="postalCode")
	private WebElement postalCode;
	
	@FindBy(name="country")
	private WebElement country;
	
	@FindBy(id = "email")
	private WebElement reg_username;
	
	@FindBy(name = "password")
	private WebElement reg_password;
	
	@FindBy(name="confirmPassword")
	private WebElement reg_confirmPassword;
	
	@FindBy(id = "register-btn")
	private WebElement submit;
	
	public Registration(WebDriver driver) {
		this.driver =driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		PageFactory.initElements(driver, this);
	}
	
	public void goToPage() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
	}
	
	public void enter_userdetails(String first_name, String last_name,String phone, String email) throws InterruptedException {
		this.firstName.sendKeys(first_name);
		this.lastName.sendKeys(last_name);
		Thread.sleep(2300);
		this.phone.sendKeys(phone);
		this.email.sendKeys(email);
		Thread.sleep(2300);
	}
	
	public void enter_mailInfo(String address, String city, String state, String postalCode, String country) throws InterruptedException {
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.postalCode.sendKeys(postalCode);
		Select count = new Select(this.country);
		count.selectByVisibleText(country);
		Thread.sleep(2300);
	}
	
	public void user_credentials(String username, String password, String confirm_password) throws InterruptedException {
		this.reg_username.sendKeys(username);
		this.reg_password.sendKeys(password);
		this.reg_confirmPassword.sendKeys(confirm_password);
		Thread.sleep(2300);
		this.submit.click();
	}
	
	
}	
