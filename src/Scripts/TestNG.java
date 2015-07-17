package Scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 


public class TestNG {
	public WebDriver driver;
	
  @Test
  public void main() {
	  
	  driver.findElement(By.id("account")).click();
	  driver.findElement(By.id("log")).sendKeys("user1");
	  driver.findElement(By.id("pwd")).sendKeys("Test@123");
	  
	  driver.findElement(By.id("login")).click();
	  
	  System.out.println("Login successful.");
	  
	  driver.findElement(By.id("account_logout"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  //initialize the firefox driver
	  driver = new FirefoxDriver();
	  
	  //Sepcify the implicit wait
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //Laucch the application
	  driver.get("http://store.demoqa.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
