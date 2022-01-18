package RunnerPackage;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",
                 glue={"stepDefinations"}
//                 tags= "@deletePlace"
                )
public class TestRunner
{
}
