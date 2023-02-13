package TestCase17;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/TestCase17", glue = "TestCase17", monochrome = true, plugin = {"html:target/cucumber.html"})
public class CucumberTestNGTestrunner extends AbstractTestNGCucumberTests{

}
