package flight.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.flight.pages.Billing_address;
import com.flight.pages.FlightDetails;
import com.flight.pages.Flight_Reservation;
import com.flight.pages.Payment_Details;
import com.flight.pages.Registration;
import com.flight.pages.Registration_Confirmation;

import flights.entry.EntryTest;


public class BookFlightTest extends EntryTest{

	//private WebDriver driver;
	
//	@BeforeTest
//	public void setUp() {
//		//System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver-win64\\chromedriver.exe");
//		this.driver = new ChromeDriver();
//		this.driver.manage().window().maximize();
//	}
//	
//	@AfterTest
//	public void tearDown() {
//		this.driver.quit();
//	}
	
	@Test
	public void registration_page() throws InterruptedException {
		
		Registration reg = new Registration(driver);
		reg.goToPage();
		reg.enter_userdetails("Miles", "Morales", "9876543210", "miles231@xmail.com");
		reg.enter_mailInfo("East House", "Mysore", "Karnataka", "641014", "INDIA");
		reg.user_credentials("miles.morales", "password", "password");
	}
	
	@Test(dependsOnMethods = "registration_page")
	public void registration_confirmation_page() {
		
		Registration_Confirmation reg_confirm = new Registration_Confirmation(driver);
		reg_confirm.goToFlight();
	}
	
	@Test(dependsOnMethods = "registration_confirmation_page")
	@Parameters({"noOfPassengers"})
	public void flight_details_page(String passengers) {
		FlightDetails details = new FlightDetails(driver);
		details.flight_Details(passengers, "London", "July", "12", "New York", "July", "13", "Unified Airlines");
	}
	
	@Test(dependsOnMethods ="flight_details_page")
	public void flight_reservation() {
		Flight_Reservation reserve = new Flight_Reservation(driver);
		reserve.flight_select();
	}
	
	@Test(dependsOnMethods = "flight_reservation")
	public void billing_address() {
		Billing_address bill = new Billing_address(driver);
		bill.address("NIL", "NIL", "Mysore", "Karnataka", "64552244");
	}
	
	@Test(dependsOnMethods = "billing_address")
	@Parameters({"bill"})
	public void payment_details_page(String bill) {
		Payment_Details pay = new Payment_Details(driver);
		String result = pay.bill();
		SoftAssert val = new SoftAssert();
		val.assertEquals(bill, result);
	}

}
