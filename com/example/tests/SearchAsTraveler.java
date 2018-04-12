package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchAsTraveler {
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
  public void testSearchAsTraveler() throws Exception {
    driver.get("http://triptailor.ddns.net/");
    Thread.sleep(2000);
    driver.findElement(By.name("start_range")).click();
    //sendKeys("20 April, 2018");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("action")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//a[contains(text(),'Trip Details')])[4]")).click();
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
