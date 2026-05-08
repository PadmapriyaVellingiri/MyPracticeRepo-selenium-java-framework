package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/FeatureFiles",
    glue = {"StepDefinition"},
    plugin = {"pretty", 	
    		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true,
    dryRun = false,
    tags = "@smoke or @sanity or @Regression"
)


public class TestRunner
{

}
