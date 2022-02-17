package com.projectRAK.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Loginrak {
@Test
public void login() {
	//invoking the chrome
System.setProperty("webdriver.chrome.driver", "C:\\Users\\deltastar1\\Desktop\\cd\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("https://dev-rak.bitnudge.com/");
try {
	Thread.sleep(60000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//Accept any valid/invalid certificates
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("acceptSslCerts", "true");
//login
WebElement username=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[1]/input"));
WebElement password=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[2]/input"));
WebElement login=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[3]/input"));
username.sendKeys("krdhiraj");
password.sendKeys("123");
login.click();
String actualUrl="https://dev-rak.bitnudge.com/login";
String expectedUrl= driver.getCurrentUrl();
Assert.assertEquals(expectedUrl,actualUrl);
System.out.println("Login Successfully!!");
}
}