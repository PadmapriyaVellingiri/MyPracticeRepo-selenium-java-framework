package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.BaseClass;

public class AddNewAccountPage extends BaseClass {
	
	WebDriver driver;
	
	public AddNewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[text()='New Account']")
	WebElement NewAccLink;	
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement Cust_Id;

	@FindBy(xpath="//select[@name='selaccount']")
	WebElement Acc_Type;

	@FindBy(xpath="//input[@name='inideposit']")
	WebElement Init_Depo;

	@FindBy(xpath="//input[@value='submit']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//td[text()='Account ID']/following-sibling::td")
	WebElement AccountID;	
	
	
	@FindBy(xpath="//p[text()='Account Generated Successfully!!!']")
	WebElement SuccessMsg;
	
	public WebElement getNewAccLink() {
	    return NewAccLink;
	}	
	
	public void clickNewAccountLink()
	{
		NewAccLink.click();	
	}
	
	public void enterCustomerId(String cust_id)
	{
		Cust_Id.sendKeys(cust_id);	
	}
	
	public void selectAccountType(String acc_type)
	{
		Select select = new Select(Acc_Type);
	    select.selectByVisibleText(acc_type);
	}

	public void enterInitialDeposit(String init_depo)
	{
		Init_Depo.sendKeys(init_depo);
	}
	
	public void clickOnSubmit()
	{
		SubmitBtn.click();
	}
	
	public void successMessage() 
	{
		SuccessMsg.getText();
	}
	
	public String getAccountID()
	{
		return AccountID.getText();
		
	}
}
