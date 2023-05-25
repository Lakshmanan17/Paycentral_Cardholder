package cardholder;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeaturesFiles/Opengoogle.feature",
glue="stepDefinitions",
monochrome=true
		)
public class Runner1class {

	//It should combined feature file and step definition
	
}