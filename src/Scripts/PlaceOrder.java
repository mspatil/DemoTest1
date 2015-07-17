package Scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 


public class PlaceOrder {
	public WebDriver driver;
	
  @Test
  public void main() {
	  
  Actions actions = new Actions(driver);
  //mousehover the product category
  WebElement productCategoryLink= driver.findElement(By.linkText("Product Category"));
  actions.moveToElement(productCategoryLink).perform();
  //select product
  WebElement productSubCategoryLink= driver.findElement(By.xpath("//header/nav/ul/li[2]/ul/li[4]/a"));
  actions.moveToElement(productSubCategoryLink).perform();
  actions.click();
  actions.perform();
  
  //Click on add to cart button
  driver.findElement(By.xpath("//article/div/div/div[3]/div[2]/form/div[2]/div[1]/span/input")).click();
  
  /*
  //switch to checkout confirm window
  Set<String> windowIterator = driver.getWindowHandles();
  
  System.out.println("Total number of windows"+ windowIterator.size());
 for (String s : windowIterator){
	 
	 WebDriver popup= driver.switchTo().window(s);
	 System.out.println("Window Title : " + popup.getTitle());
	 if(popup.getTitle().equals("fancy_notification")){
		 System.out.println("Swited the checkout window");
	 }
 }*/
    
  //Click on Goto checkout button
  driver.findElement(By.xpath("//*[@class='go_to_checkout']")).click();
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  //initialize the firefox driver
	  driver = new FirefoxDriver();
	  
	  //Sepcify the implicit wait
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //Laucch the application
	  driver.get("http://store.demoqa.com/");
	  
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
