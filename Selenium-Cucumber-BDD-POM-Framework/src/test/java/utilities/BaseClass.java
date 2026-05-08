package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	static String browserName;
	public static WebDriver driver;
	
	public static WebDriver initializeDriver()
	{
		try {
			browserName = FetchDataFromProperty.getDataFromProperty().getProperty("browser");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			driver.manage().window().maximize();
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			driver.manage().window().maximize();
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (IOException e) {
								
				e.printStackTrace();
			}
			driver.manage().window().maximize();
		}
		return driver;
				
	}
	
	public static String getTitle()
	{
		String title = driver.getTitle();
		return title;
		
	}
	
	public static void scroolPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scroolBy(0,500)", "");
	}
	
	public static String getCurremtURL()
	{
		String CURL = driver.getCurrentUrl();
		return CURL;
	}
	
	public static String getEmail()
	{
		String email = "tom" + java.util.UUID.randomUUID().toString().replace("-", "").substring(0,8) + "@gmail.com";
		return email;
				
	}
	
	public static void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	public static WebElement waitForVisibility(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void logout() {
	    try {
	        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Log out']"));
	        logoutBtn.click();

	        // Optional: wait for login page to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.titleContains("Login"));

	        System.out.println("Logged out successfully");
	    } catch (Exception e) {
	        System.out.println("Logout failed: " + e.getMessage());
	    }
	}
	
	
	
	
	
	
	
}
