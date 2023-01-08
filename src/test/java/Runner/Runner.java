package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue={"Steps"},
        plugin = {"html:target/cucumber-html-reports.html","pretty"}
)
public class Runner {

}
