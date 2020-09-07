package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver;
	
	String Baseurl = "http://182.74.238.221/clarion_promise_qa/index.php";
	String ExceptedTile = "Promises Log" ;
	String actualTitle = "";
	String ByCheckingVlidation = "//*[text()='Invalid Username/password']";
	String ByUsername = "//input[@class='input_box' and @name='txtUsername']";
	String ByPassword = "//input[@class='input_box' and @name='txtPassword']";
	String ByBtnLogin = "//input[@class='button_white' and @name='submit1']";
	String ByWelcomeText = "//*[text()='Logged as: ']";
	String ByLogPromiseLink = "//*[text()='Log Promise']";
	String ByClickDropDown = "//select[@name='cboEmp']";
	String BytextareaMsg = "//*[@name='txtPromise']";
	String ByLogPromiseBtn = "//*[@name='btnSubmit' and @value='Log Promise']";
	String BysuccessfulPromiseVerification = "//*[text()='Promise added successfully']";
	String BySearchBtn = "//input[@name='btnSearch']";
	String BycheckpromiseisAdd = "//td[text()='This is a Prmoise Test for testing purpose']";

System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\rashmichavan\\Pictures\\chromedriver_win32\\chromedriver.exe");

driver=new ChromeDriver();
driver.manage().window().maximize();

driver.get(Baseurl);
actualTitle = driver.getTitle();
System.out.println(actualTitle);
Thread.sleep(3000);

if(actualTitle.contentEquals(ExceptedTile)){
	
	System.out.println("Test passed");
}
else{
	
	System.out.println("Test failed");
}

//checking validations...
System.out.println("Checking validations...");
driver.findElement(By.xpath("//input[@class='button_white' and @name='submit1']")).click();
System.out.println("Login button clicked...");
String checkvalidations = driver.findElement(By.xpath(ByCheckingVlidation)).getText();
System.out.println("Error message: "+checkvalidations);
System.out.println("Validation is verified...");

Thread.sleep(2000);

//Logging to the application...

driver.findElement(By.xpath(ByUsername)).sendKeys("sanjeetk@clariontechnologies.co.in");
Thread.sleep(2000);
driver.findElement(By.xpath(ByPassword)).sendKeys("clarion");
Thread.sleep(2000);
driver.findElement(By.xpath(ByBtnLogin)).click();

//Verify user is able to login to the application...

String checkedmsg = driver.findElement(By.xpath(ByWelcomeText)).getText();
System.out.println("User has logged in as: user name: "+checkedmsg);
driver.findElement(By.xpath(ByLogPromiseLink)).click();
Thread.sleep(3000);

//selecting value from the drop down...

driver.findElement(By.xpath(ByClickDropDown)).click();
Select dropdownvalue = new Select(driver.findElement(By.xpath(ByClickDropDown)));
dropdownvalue.selectByVisibleText("Sonali test");
Thread.sleep(3000);


driver.findElement(By.xpath(BytextareaMsg)).sendKeys("name should be added as a test and verify after adding it");
driver.findElement(By.xpath(ByLogPromiseBtn)).click();

//checking if the promise is added or not...
String promiseaddedmsg = driver.findElement(By.xpath(BysuccessfulPromiseVerification)).getText();
System.out.println("Verify promise is added: "+promiseaddedmsg);


//checking whether promise "sonali test" is added or not...

driver.findElement(By.xpath(ByClickDropDown)).click();
Select dropdownvalue1 = new Select(driver.findElement(By.xpath(ByClickDropDown)));
dropdownvalue1.selectByVisibleText("Sonali test");
Thread.sleep(3000);

driver.findElement(By.xpath(BySearchBtn)).click();
Thread.sleep(2000);

String VerifyPromiseisAdded = driver.findElement(By.xpath(BycheckpromiseisAdd)).getText();
System.out.println("Promise is added successfully: Read the description: "+VerifyPromiseisAdded);

Thread.sleep(2000);
driver.close();


}

}