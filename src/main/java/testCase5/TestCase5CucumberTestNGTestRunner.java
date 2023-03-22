package testCase5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/testCase5", glue = "testCase5", monochrome = true, plugin = {"html: target/cucumber.html"})
public class TestCase5CucumberTestNGTestRunner extends AbstractTestNGCucumberTests{

}
