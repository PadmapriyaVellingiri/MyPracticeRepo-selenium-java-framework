package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.ConstantsData;
import PageRepository.AddNewAccountPage;
import PageRepository.LoginPage;
import PageRepository.MyLogout;
import PageRepository.NewCustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.FetchDataFromExcel;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

public class StepDefinition extends BaseClass {
	
	
	WebDriver driver = BaseClass.initializeDriver();
	LoginPage obj = new LoginPage(driver);	
	NewCustomerPage obj1 = new NewCustomerPage(driver);
	NewCustomerPage addCustomerPage;
	AddNewAccountPage newAccountPage;
	MyLogout myLogOutPage = new MyLogout(driver);
	Map<String, String> testData;
	Map<String, String> accountData;
	
	@Given("user opens the browser URL")
	public void user_opens_the_browser_url() throws IOException {
		getTitle();
		String url = FetchDataFromExcel.getURL(1, 0);
	    System.out.println("URL from Excel: " + url);

	    driver.get(url);
	}

	@Given("user enters the username as {string}")
	public void user_enters_the_username_as(String uname) {
	    obj.enterUname(uname);
	}

	@Given("user enters the password as {string}")
	public void user_enters_the_password_as(String password) {
	    obj.enterPasword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		obj.clickLogin();

	}

	@Then("validate that user navigates to the homepage of the application")
	public void validate_that_user_navigates_to_the_homepage_of_the_application() {
	 String URL1 = getCurremtURL();
	 if (URL1.contains("homepage"))
	 {
		 System.out.println("User navigate to correct page");
	 }
	 else
	 {
		 throw new NullPointerException("Page Navigation not Successfull");
	 }
	}
	
	
	@Given("user is on home page of the application")
	public void user_is_on_home_page_of_the_application() {
	   getTitle();
	   // ✅ Instantiate the Page Object
       newAccountPage = new AddNewAccountPage(driver); 
	}

	@Given("user clicks on new customer link")
	public void user_clicks_on_new_customer_link() {
	   obj1.clickOnNewCustomer();
	    addCustomerPage = new NewCustomerPage(driver);
	    addCustomerPage.clickOnNewCustomer();
	}
	
	@When("user enter customer details")
	public void user_enter_customer_details(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

	    addCustomerPage.enterUserName(data.get("cust_name"));
	    addCustomerPage.selectGender(data.get("gender"));
	    addCustomerPage.enterDob(data.get("dob"));
	    addCustomerPage.enterAddress(data.get("address"));
	    addCustomerPage.enterCity(data.get("city"));
	    addCustomerPage.enterState(data.get("state"));
	    addCustomerPage.enterPin(data.get("pin"));
	    addCustomerPage.enterTelephone(data.get("telephone"));
//	    addCustomerPage.enterEmail(data.get("email"));
	 // ⭐ Dynamic email
	    String email;

	    if (data.get("email").equalsIgnoreCase("dynamic")) {
	        email = BaseClass.getEmail();
	    } else {
	        email = data.get("email");
	    }

	    System.out.println("Generated Email: " + email);

	    addCustomerPage.enterEmail(email);
	    addCustomerPage.enterPassword(data.get("password"));
	}
	
	@Given("user enter customer name as {string}")
	public void user_enter_customer_name_as(String cust_name) {
	   obj1.enterUserName(cust_name);
	}

	@Given("user selects the gender {string}")
	public void user_selects_the_gender(String gender) {
	    obj1.selectGender(gender);    
	}
	
	@Given("user selects the dateofBirth as {string}")
	public void user_selects_the_dateof_birth_as(String dob) {
	   obj1.enterDob(dob);
	}

	@Given("user enters the address as {string}")
	public void user_enters_the_address_as(String address) {
	   obj1.enterAddress(address);
	}

	@Given("user enters the state as {string}")
	public void user_enters_the_state_as(String state) {
	    obj1.enterState(state);
	}

	@Given("user enters the city as {string}")
	public void user_enters_the_city_as(String city) {
	 obj1.enterCity(city);   
	}

	@Given("user enters the pin as {string}")
	public void user_enters_the_pin_as(String pin) {
	    obj1.enterPin(pin);
	}

	@Given("user enters the telephone as {string}")
	public void user_enters_the_telephone_as(String telephone) {
		obj1.enterTelephone(telephone);

	}

	@Given("user enters the email as email")
	public void user_enters_the_email_as_email() {
		obj1.enterEmail(getEmail());
	}

	@Given("user enters the {string}")
	public void user_enters_the(String password) {
		obj1.enterPassword(password);
	}
	
	@Then("user captures the customer id")
	public void user_captures_the_customer_id() throws IOException, InterruptedException {
		String customerId = addCustomerPage.getCustomerId();
	    System.out.println("Captured Customer ID: " + customerId);
	    FetchDataFromExcel.writeCustomerId(customerId);
	}
	
	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		obj1.submit(); 

	}

	@Then("new customer will be created")
	public void new_customer_will_be_created() {
		getTitle();
	}
	
	@Given("user clicks on New Account link")
	public void user_clicks_on_new_account_link() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newAccLink = newAccountPage.getNewAccLink();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='New Account']")));
		wait.until(ExpectedConditions.elementToBeClickable(newAccLink));
	    newAccountPage.clickNewAccountLink();
	}
	
	@Given("user fetches testdata from excel")
	public void user_fetches_testdata_from_excel() throws IOException {
		 accountData = FetchDataFromExcel.readAccountData();
		 System.out.println("Excel Data: " + accountData);
    }
	
	@Given("user enter the Customer ID")
	public void user_enter_the_customer_id() {
		String custId = FetchDataFromExcel.readCustomerID(1);
	    newAccountPage.enterCustomerId(custId);
	}

	@Given("the user selects the account type")
	public void the_user_selects_the_account_type() {
		String accType = accountData.get("AccountType");
		newAccountPage.selectAccountType(accType);
	    
	}

	@Given("the user enters the initial deposit")
	public void the_user_enters_the_initial_deposit() {
			 String deposit = FetchDataFromExcel.readCustomerID(1);
		    newAccountPage.enterInitialDeposit(deposit);
	}
	
	@Given("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String string) {
		newAccountPage.clickOnSubmit();
	}

	@Then("the account should be created successfully")
	public void the_account_should_be_created_successfully() {
		newAccountPage.successMessage();
	}

	@Then("the user should see the new account ID generated")
	public void the_user_should_see_the_new_account_id_generated() {
		String accId = newAccountPage.getAccountID();
	    System.out.println("Captured Account ID: " + accId);
	    FetchDataFromExcel.writeAccountID(accId);
	}
	
	@When("user clicks on logout link")
	public void user_clicks_on_logout_link() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log out']")));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    // scroll element to center of screen (not top)
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", logoutElement);
	    // JS click (bypasses overlapping issue)
	    js.executeScript("arguments[0].click();", logoutElement);	
		//myLogOutPage.myLogOut();
	}

	@Then("user should see logout confirmation alert")
	public void user_should_see_logout_confirmation_alert() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertMessage = alert.getText();
	    System.out.println("Alert message: " + alertMessage);

	    // Validation (important in automation)
	    Assert.assertEquals(alertMessage, "You Have Succesfully Logged Out!!");

	   // alert.accept();
	}

	@Then("user accepts the alert")
	public void user_accepts_the_alert() {
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		}

	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {
		String actualTitle = driver.getTitle();
	    String expectedTitle = "Guru99 Bank Home Page";
	    Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() throws InterruptedException {
		closeBrowser();
		
	}

}
