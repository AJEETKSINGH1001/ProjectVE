package com.projectVE.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditCustomer extends BaseClass {
	
	@Test
	public void login_and_editcustomer() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\deltastar1\\Desktop\\cd\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/v4/index.php");
	WebElement username=driver.findElement(By.name("uid"));
	WebElement password=driver.findElement(By.name("password"));
	WebElement login=driver.findElement(By.name("btnLogin"));
	username.sendKeys("mngr379751");
	password.sendKeys("nEsEpUg");
	login.click();
	// editing customer
	driver.get("http://demo.guru99.com/v4/manager/EditCustomer.php");
	WebElement uid=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input"));
	uid.sendKeys("44041");
	
	WebElement submit=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]"));
	submit.click();
	
	WebElement city =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));
    city.click();
    city.sendKeys(Keys.BACK_SPACE);
    city.clear();
    city.sendKeys("New york");
    WebElement update=driver.findElement(By.name("sub"));
    update.click();
    String actualString="Customer details updated Successfully!!!";
    driver.switchTo().alert().getText();
    String expectedString= "";
    Assert.assertEquals(expectedString,actualString);
    
	
}}
