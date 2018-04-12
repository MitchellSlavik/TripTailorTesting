package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ViewTripAsGuide {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  	System.setProperty("webdriver.chrome.driver","C:\\Users\\Colin\\Desktop\\chromedriver_win32\\chromedriver.exe");
	  	driver = new ChromeDriver();
	  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

  @Test
  public void testViewTripAsGuide() throws Exception {
    driver.get("http://triptailor.ddns.net/");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Guide Space")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    Thread.sleep(2000);
    driver.findElement(By.name("username")).sendKeys("selTestGuide");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test1");
    Thread.sleep(2000);
    driver.findElement(By.id("login_form")).submit();
    driver.get("http://triptailor.ddns.net/");
    driver.findElement(By.xpath("//div/div/div")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Dashboard")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[contains(@href, '/trip/8')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("Next")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("Next")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("Stop 1 - Brooklyn Bridge")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Stop 2 - Empire State Building")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Stop 3 - Statue of Liberty National Monument")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath("(//a[contains(text(),'Testing Guide')])[2]")).click();
    Thread.sleep(2000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
