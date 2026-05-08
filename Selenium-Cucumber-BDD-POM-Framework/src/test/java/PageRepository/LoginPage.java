package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LoginPage extends BaseClass{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//input[@name='uid']")
	WebElement uname;
	
	@FindBy (xpath="//input[@type='password']")
	WebElement pwd;
	
	@FindBy (xpath="//input[@name='btnLogin']")
	WebElement login_Btn;
	
	public void enterUname(String username)
	{
		uname.sendKeys(username);
	}
	
	public void enterPasword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login_Btn.click();	
	}
}
