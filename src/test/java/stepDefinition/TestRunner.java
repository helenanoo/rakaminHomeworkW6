package stepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",glue= {"stepDefinition"},
monochrome=true,
plugin= {"html:target/HTML_report.html"}
)
public class TestRunner {
}
