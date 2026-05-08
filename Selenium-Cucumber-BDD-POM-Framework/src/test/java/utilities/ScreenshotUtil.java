package utilities;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	public class ScreenshotUtil {

	    public static String captureScreenshot(WebDriver driver, String scenarioName) {

	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String fileName = scenarioName + "_" + timeStamp + ".png";

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String destination = System.getProperty("user.dir") 
	                + "/test-output/Screenshots/" + fileName;

	        try {
	            FileUtils.copyFile(src, new File(destination));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return destination;  // important for Extent report
	    }
	}


