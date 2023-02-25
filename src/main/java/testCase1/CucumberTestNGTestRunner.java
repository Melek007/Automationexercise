package testCase1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/testCase1", glue = "testCase1", monochrome = true, plugin = {"html:target/cucumber.html"})
public class CucumberTestNGTestRunner extends AbstractTestNGCucumberTests{

}
