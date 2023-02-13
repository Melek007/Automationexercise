package TestCase3;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/TestCase3", glue = "TestCase3", monochrome = true, plugin = {"html:target/cucumber.html"})
public class CucumberTestngTestrunner extends AbstractTestNGCucumberTests{

}
