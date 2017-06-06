package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by basar on 06/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"} , format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests{
}
