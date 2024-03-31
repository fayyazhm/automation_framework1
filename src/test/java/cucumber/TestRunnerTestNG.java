package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/cucumber",
	    glue = "fayyaz.stepdefinition",
	    monochrome = true,
	    plugin = {"html:target/cucumber.html","json:target/cucumber.json"}
	)
	public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	    // This class doesn't need any content as it inherits AbstractTestNGCucumberTests
	    // and will run Cucumber tests based on the provided options.
	}
