package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LogOutTraveler {
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
  public void testLogOutTraveler() throws Exception {
    driver.get("http://triptailor.ddns.net/");
    Thread.sleep(2000);
    driver.findElement(By.linkText("Log in")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("TestingSel");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test");
    Thread.sleep(2000);
    driver.findElement(By.id("login_form")).submit();
    Thread.sleep(2000);
    driver.get("http://triptailor.ddns.net/");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div/div/div")).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Log Out")).click();
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
