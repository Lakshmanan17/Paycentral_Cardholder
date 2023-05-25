package stepDefinitions;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_with_exceldata {
	public static WebDriver driver;
	static List<String> userNameList=new ArrayList<String>();
	static List<String> passwordList=new ArrayList<String>();

	@Given("^User is given input data to excel sheet$")
	public void user_is_given_input_data_to_excel_sheet() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//public void readexcel() throws IOException 
		for(int i=0; i<userNameList.size();i++) {
			data_s_send_to_input_fields(userNameList.get(i), passwordList.get(i));
			
		}
	}

		
	

	@When("^read the excel data$")
	public void read_the_excel_data() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        {
			
			FileInputStream excel=new FileInputStream("C:\\Users\\Lakshmanan\\Desktop\\input.xlsx");
			Workbook workbook= new XSSFWorkbook(excel);
			Sheet sheet =workbook.getSheetAt(0);
			Iterator<Row> rowIterator=sheet.iterator();
			while(rowIterator.hasNext()) {
				Row rowValue=rowIterator.next();
				Iterator<Cell> columnIterator=rowValue.iterator();
				int i=2;
			while(columnIterator.hasNext())	{
				if(i%2==0) {
					userNameList.add(columnIterator.next().getStringCellValue());
				}else {			
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
			}
		}
	    
	}

	@When("^data's' send to input fields$")
	public void data_s_send_to_input_fields(String Username,String Password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://chp.paycentral.co.za/");
		WebElement username=driver.findElement(By.xpath("//input[@name='cardnumber']"));
		username.sendKeys(Username);
		
		WebElement password=driver.findElement(By.xpath("//input[@name='ID Number']"));
		password.sendKeys(Password);
		
		WebElement submit=driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/html/div[1]/div[2]/form/div/div[3]/div[2]/button"));
		submit.click();
	}

	@Then("^Authenticated and login the cardholder portal$")
	public static void main(String[] args) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login_with_exceldata usingPOI= new Login_with_exceldata();
		usingPOI.read_the_excel_data();
		System.out.println("userNameList"+ userNameList);
		System.out.println("passwordList"+ passwordList);
		usingPOI.user_is_given_input_data_to_excel_sheet();
	}
}
