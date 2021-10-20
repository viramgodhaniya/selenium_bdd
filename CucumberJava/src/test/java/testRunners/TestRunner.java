package testRunners;

import config.BrowserLaunch;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/GoogleSearch.feature", 
glue= {"StepDefinitions"},
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports"}
		)
public class TestRunner {

	static BrowserLaunch browserLaunch = new BrowserLaunch();

	@BeforeClass
	public static void launchBrowser() {
		browserLaunch.launch();
	}

	@AfterClass
	public static void CloseBrowser() {
		browserLaunch.quitDriver();
	}
}
