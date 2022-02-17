package projectraktrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Loginrak {
@Test
public void login() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\deltastar1\\Desktop\\cd\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://cron-rak.bitnudge.com/login");
WebElement username=driver.findElement(By.name("User ID"));
WebElement password=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[2]/input"));
WebElement login=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[3]/input"));
username.sendKeys("naveen");
password.sendKeys("123");
login.click();
String actualUrl="https://cron-rak.bitnudge.com/userFlow/main";
String expectedUrl= driver.getCurrentUrl();
Assert.assertEquals(expectedUrl,actualUrl);
System.out.println("Login Successfully!!");
}
}