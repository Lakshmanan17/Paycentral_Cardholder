package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_datatab {
	WebDriver driver;
	
	@Given("^Customer is on login page$")
	public void customer_is_on_login_page() throws Throwable {
	
		//System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://chp.paycentral.co.za/");
		driver.manage().window().maximize();
	}

	@When("^Customer enter valid usernameand password$")
	public void customer_enter_valid_usernameand_password(DataTable datatable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		List<String> credentials=datatable.asList(String.class);
		String username=credentials.get(0);
		String password=credentials.get(1);
		
		 driver.findElement(By.xpath("//div[@id=\"c1\"]/div[1]/div/input")).sendKeys(username);
		    
		 driver.findElement(By.xpath("//div[@id=\"c1\"]/div[2]/div/input")).sendKeys(password);
		    
	  
	}

	@When("^click in the login button$")
	public void click_in_the_login_button() throws Throwable {
	
		 driver.findElement(By.xpath("//button[@id=\"login\"]")).click();
	}

	@Then("^the user will pass to home page$")
	public void the_user_will_pass_to_home_page() throws Throwable {
		System.out.println("Cardholder portal login successfully");
	    
	}



}
