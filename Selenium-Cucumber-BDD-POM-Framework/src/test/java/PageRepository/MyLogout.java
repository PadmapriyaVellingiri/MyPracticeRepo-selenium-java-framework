package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLogout {
	

WebDriver driver;
	
	public MyLogout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Log out']")
	WebElement LogOut;
	
	public WebElement getLogoutElement() {
	    return LogOut;
	}
	
	public void myLogOut()
	{
		LogOut.click();
	}

}
