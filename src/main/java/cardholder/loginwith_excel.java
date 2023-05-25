package cardholder;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeaturesFiles/Readexcel.feature",
glue="stepDefinitions",
monochrome=true
		)
public class loginwith_excel {

}
