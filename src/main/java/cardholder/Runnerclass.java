package cardholder;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeaturesFiles/Login_Datatable_header.feature",
glue="stepDefinitions",
monochrome=true
		)
public class Runnerclass {

	//It should combined feature file and step definition
	
}