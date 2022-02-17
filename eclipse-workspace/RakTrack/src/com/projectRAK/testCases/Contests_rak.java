package com.projectRAK.testCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

class TestClass1 implements Runnable {
public void run() {
    Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
    capsHashtable.put("browserName", "Chrome");
    capsHashtable.put("version", "92.0");
    capsHashtable.put("platform", "Windows 10");
    capsHashtable.put("resolution", "1024x768");
    capsHashtable.put("build", "RAK TRACK");
    capsHashtable.put("name", "Rak- contests ui on chrome");
    Contests_rak r1 = new Contests_rak();
    r1.executeTest(capsHashtable);
}
}
class TestClass2 implements Runnable {
  public void run() {
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "Firefox");
      capsHashtable.put("version", "96.0");
      capsHashtable.put("platform", "Windows 10");
      capsHashtable.put("resolution", "1280x800");
      capsHashtable.put("build", "RAK TRACK");
      capsHashtable.put("name", "Rak- contests ui on firefox");
      Contests_rak r2 = new Contests_rak();
      r2.executeTest(capsHashtable);
  }
}
class TestClass3 implements Runnable {
  public void run() {
      Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
      capsHashtable.put("browserName", "Opera");
      capsHashtable.put("version", "82.0");
      capsHashtable.put("platform", "Windows 10");
      capsHashtable.put("resolution", "1366x768");
      capsHashtable.put("build", "RAK TRACK");
      capsHashtable.put("name", "Rak- contests ui on safari");
      Contests_rak r3 = new Contests_rak();
      r3.executeTest(capsHashtable);
  }
}
public class Contests_rak {
  public static final String USERNAME = "xonier.ajeet";
  public static final String AUTOMATE_KEY = "ivRViTWr3lnD1EmCxVvacwjLF4PmTsQdIVqIFxup4pA8ulBPo3";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
  public static void main(String[] args) throws Exception {
    Thread object1 = new Thread(new TestClass1());
    object1.start();
    Thread object2 = new Thread(new TestClass2());
    object2.start();
    Thread object3 = new Thread(new TestClass3());
    object3.start();
  }
  public void executeTest(Hashtable < String, String > capsHashtable) {
    String key;
    DesiredCapabilities caps = new DesiredCapabilities();
    // Iterate over the hashtable and set the capabilities
    Set < String > keys = capsHashtable.keySet();
    Iterator < String > itr = keys.iterator();
    while (itr.hasNext()) {
      key = itr.next();
      caps.setCapability(key, capsHashtable.get(key));
    }
    WebDriver driver;
    try {
      driver = new RemoteWebDriver(new URL(URL), caps);
      driver.get("https://app-rak.bitnudge.dev");
      try {
      	Thread.sleep(60000);
      } catch (InterruptedException e) {
      	// TODO Auto-generated catch block
      	e.printStackTrace();
      }
      //login
      WebElement username=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[1]/input"));
      WebElement password=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[2]/input"));
      WebElement login=driver.findElement(By.xpath("//*[@id=\"loginScreen\"]/div/div/div[1]/div[2]/div[2]/form/div[3]/input"));
      username.sendKeys("krdhiraj");
      password.sendKeys("123");
      login.click();
      String actualUrl="https://app-rak.bitnudge.dev/login";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
      System.out.println("Login pass");
      //take screenshots
    //Convert web driver object to TakeScreenshot
      TakesScreenshot scrShot =((TakesScreenshot)driver);
      //Call getScreenshotAs method to create image file
      File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
      //Move image file to new destination
      File DestFile=new File(AUTOMATE_KEY);
      //Copy file at destination
      FileUtils.copyFile(SrcFile, DestFile);
      //Checking the contest page
      //https://dev-rak.bitnudge.com/userFlow/campaigns 
			/*
			 * String baseUrl = "https://app-rak.bitnudge.dev/userFlow/campaigns";
			 * System.out.println("At the contest page"); driver.get(baseUrl);
			 * driver.getTitle();
			 */
		driver.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}