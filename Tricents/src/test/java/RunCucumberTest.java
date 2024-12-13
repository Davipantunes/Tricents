import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps"},
        features = "src/main/resources/features",
        tags = "not @ignore",
        plugin = {"pretty","html:target/cucumber.report.html"}
)

public class RunCucumberTest {
}
