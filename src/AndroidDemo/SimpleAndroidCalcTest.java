package AndroidDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SimpleAndroidCalcTest {

 AndroidDriver driver;
 public String APKPath = "D://BBC-Demo//Builds//smp-an.apk";

 @BeforeTest
 public void setUp() throws MalformedURLException {
  // Created object of DesiredCapabilities class.
  DesiredCapabilities capabilities = new DesiredCapabilities();

  
  capabilities.setCapability("deviceName", "ZX1B32FFXF");
  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
  capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("app", APKPath);
  capabilities.setCapability("appPackage", "uk.co.bbc.avtestharnesssmp");//"com.android.calculator2");
  capabilities.setCapability("appActivity", "uk.co.bbc.avtestharnesssmp.MainActivity");
  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

 @Test
 public void Sum() {
  WebElement videolink = "";
  driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

  // Click on number 2 button.
  driver.findElement(By.name("2")).click();

  // Click on + button.
  driver.findElement(By.name("+")).click();

  // Click on number 5 button.
  driver.findElement(By.name("5")).click();

  // Click on = button.
  driver.findElement(By.name("=")).click();

  // Get result from result text box.
  String result = driver.findElement(By.className("android.widget.EditText")).getText();
  System.out.println("Number sum result is : " + result);

 }

@AfterTest
 public void End() {
  driver.quit();
 }
}