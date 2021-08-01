package Cucumber.TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Cucumber/Features",
        glue= "Cucumber/stepDefination")
public class TestRunner extends AbstractTestNGCucumberTests {
}
