package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class NewCustomerPage extends BaseClass {

WebDriver driver;
	
	public NewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCustLink;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement Cust_name;
	
	@FindBy(xpath="//input[@type='radio'][1]")
	WebElement MaleRadio;

	@FindBy(xpath="//input[@type='radio'][2]")
	WebElement FemaleRadio;
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement Dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement Address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement State;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement Pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement Telephone;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement Emailid;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement Submit;
	
	@FindBy(xpath="//input[@value='Reset']")
	WebElement Reset;
	
	@FindBy(xpath="//td[text()='Customer ID']/following-sibling::td")
	WebElement CustId;
	
	public void clickOnNewCustomer()
	{
		NewCustLink.click();	
	}
	
	public void enterUserName(String cname)
	{
		Cust_name.sendKeys(cname);	
	}
	
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
	    {
	        MaleRadio.click();
	    }
	    else if(gender.equalsIgnoreCase("female"))
	    {
	        FemaleRadio.click();
	    }
	}
	
	public void enterDob(String dob)
	{
		Dob.sendKeys(dob);		
	}
	
	public void enterAddress(String address)
	{
		Address.sendKeys(address);		
	}
	
	public void enterState(String state)
	{
		State.sendKeys(state);		
	}
	
	public void enterCity(String city)
	{
		City.sendKeys(city);		
	}
	
	public void enterPin(String pin)
	{
		Pin.sendKeys(pin);		
	}
	
	public void enterTelephone(String telephone)
	{
		Telephone.sendKeys(telephone);		
	}
	
	public void enterEmail(String email)
	{
		Emailid.sendKeys(email);		
	}
	
	public void enterPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public void submit()
	{
		Submit.click();
	}
	
	public String getCustomerId() {
	    return CustId.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
}
