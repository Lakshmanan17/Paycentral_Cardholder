package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginsteps {
	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://chp.paycentral.co.za/");
		driver.manage().window().maximize();
	}

	@When("^user enter valid and password=\"([^\"]*)\"$")
	public void user_enter_valid_and_password(String password) throws Throwable {
	    WebElement id= driver.findElement(By.xpath("//input[@id='cardnum']"));
	    id.sendKeys("5192607817637308");
	    WebElement pwd= driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/main/div/div/div/section[2]/div/form/div[1]/div[2]/input"));
	    pwd.sendKeys(password);
	}

	@When("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/main/div/div/div/section[2]/div/form/div[1]/div[3]/div[2]/button")).click();
	}

	@Then("^the user will navigate to home page$")
	public void the_user_will_navigate_to_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	System.out.println("Cardholder portal login successfully");
	}


	
}
