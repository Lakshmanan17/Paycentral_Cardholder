package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Opengoogledefinition {
	WebDriver driver;
	@Given("^user is entering google\\.com$")
	public void user_is_entering_google_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

	@When("^types the search term as \"([^\"]*)\"$")
	public void types_the_search_term_as(String searchTerm) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		 driver.findElement(By.name("q")).sendKeys(searchTerm);
	}

	
	@When("^user clicks the search box$")
	public void user_clicks_the_search_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	}

	
	@Then("^the user should see the search results for Lakshmanan$")
	public void the_user_should_see_the_search_results_for_Lakshmanan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		boolean resultsCame=driver.findElement(By.partialLinkText("ramayanan lakshmanan")).isDisplayed();
		  if(true==resultsCame){
		   System.out.println("search results came");
		  }else{
		   System.out.println("Some error");
		  }
	}


}
