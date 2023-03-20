package testCase2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/testCase2", glue = "testCase2", monochrome = true, plugin = {"html: target/cucumber.html"})
public class TestCase2CucumberTestNGTestRunner extends AbstractTestNGCucumberTests{

}
