package StepDefinition;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import io.cucumber.java.After;
	import io.cucumber.java.Scenario;
	import utilities.BaseClass;
	
	
	public class Hooks {

	    WebDriver driver = BaseClass.driver;  // or however you access driver

	    @After
	    public void tearDown(Scenario scenario) {

	        if (scenario.isFailed()) {
	        	try {
	                File screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.FILE);

	                byte[] fileContent = Files.readAllBytes(screenshot.toPath());

	                scenario.attach(fileContent, "image/png", scenario.getName());

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        	
	        }

	        driver.quit();
	    }   
	}

