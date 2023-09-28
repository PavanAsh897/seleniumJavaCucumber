package TestRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= "C:\\Users\\pashadapu\\eclipse-workspace\\SeleniumJavaBDD\\src\\test\\resources\\Features"
		,glue= "stepDefination",
		plugin= {"pretty","html:test-output"},

monochrome = true, dryRun = false, publish = true)




public class TestRunner {

}
