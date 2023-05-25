package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Datatable_with_header {
	WebDriver driver;

@Given("^User login the page$")
public void user_login_the_page() throws Throwable {
	System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://chp.paycentral.co.za/");
	
}


@When("^User can enter valid username and password$")
public void user_can_enter_valid_usernameand_password(DataTable datatable) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	
   List<Map<String,String>> Keyvaluepair= datatable.asMaps(String.class, String.class);
   System.out.println(Keyvaluepair);
   String username=Keyvaluepair.get(0).get("Username");
   String password=Keyvaluepair.get(0).get("Password");
   driver.findElement(By.xpath("//input[@id='cardnum']")).sendKeys(username);   
   driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/main/div/div/div/section[2]/div/form/div[1]/div[2]/input")).sendKeys(password);
}

@When("^click the logon button$")
public void click_the_logon_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/main/div/div/div/section[2]/div/form/div[1]/div[3]/div[2]/button")).click();
}

@Then("^the user will view to home page$")
public void the_user_will_view_to_home_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Cardholder portal login successfully");
}



}
