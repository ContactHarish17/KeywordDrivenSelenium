package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"D:\\KeywordDriven-Selenium\\artCucumber\\src\\test\\resources\\Features\\OnBoarding.feature"},
		glue = {"StepDefinitions"},
		monochrome= true,
		plugin = {"pretty",
				"html:target/HtmlReports",
				"json:target/JSONReports/report.json",
				"junit:target/JUniReports/report.xml"}
		)
public class CucumberTestRunner {

}


