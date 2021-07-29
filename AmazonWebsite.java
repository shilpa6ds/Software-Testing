package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class AmazonWebsite

{

public static void main(String[] args) throws InterruptedException

{
System.setProperty("webdriver.chrome.driver","/Users/shilpa/Desktop/SWD/chromedriver/chromedriver");
WebDriver driver=new ChromeDriver();

//AMAZON WEB PAGE
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();

//LOGIN PAGE
driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[9]/div[2]/a[1]/span[1]")).click();
//ENTER MOBILE NUMBER AND PASSWORD
driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("7358777236");
driver.findElement(By.xpath("//input[@id='continue']")).click();
driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("shilpa");
driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

//RADIO BUTTON
driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[1]/span[1]/span[2]/span[1]")).click();
driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='customer-preferences']/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/label[1]/i[1]")).click();
driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='customer-preferences']/div[1]/div[1]/form[1]/span[2]/span[1]/input[1]")).click();

//TITLE CHECK
String expectedTitle = "Amazon.in";
String actualTitle = driver.getTitle();

if(actualTitle.contentEquals(expectedTitle))
{
System.out.println("Test Passed !");

}
else
{
System.out.println("Test Failed !");
}

//CHOOSE MOBILES
driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).click();

//CHECKBOX-ONE PLUS
driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[5]/ul[1]/li[1]/span[1]/a[1]/span[1]")).click();

//MOUSE OVER A PRODUCT
driver.findElement(By.xpath("//span[contains(text(),'OnePlus Bullets Wireless Z Bass Edition (Bold Blac')]")).click();

//HANDLE MULTIPLE WINDOW
String Mainwindow= driver.getWindowHandle();
Set<String> s1= driver.getWindowHandles();
Iterator<String> i1=s1.iterator();
while(i1.hasNext())
{
String childwindow=i1.next();
if(!Mainwindow.equalsIgnoreCase(childwindow))
{
driver.switchTo().window(childwindow);
}
System.out.println("Handling Multiple Window!");
}
//DROP DOWN
Select quan= new Select(driver.findElement(By.name("quantity")));
quan.selectByValue("2");

//CHECK BOX
driver.findElement(By.xpath("//input[@id='gift-wrap']")).click();

//ADD TO CART
driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

//SEARCH BAR
driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Chocolates");
driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

//SCROLL DOWN
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,200)");
Thread.sleep(3000);
js.executeScript("window.scrollBy(0,-200)");


//SELECT LINK TEXT
driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/span[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/a[1]/section[1]/span[1]")).click();


//LOGOUT
driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]")).click();
driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
driver.navigate().back();

driver.close();

}

}

