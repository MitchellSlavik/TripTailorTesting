package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GuideRegister {
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
  public void testGuideRegister() throws Exception {
    driver.get("http://triptailor.ddns.net/");
    Thread.sleep(1500);
    driver.findElement(By.linkText("Guide Space")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("GUIDE SIGN UP")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("id_first_name")).click();
    driver.findElement(By.id("id_first_name")).clear();
    driver.findElement(By.id("id_first_name")).sendKeys("Testing");
    driver.findElement(By.id("id_last_name")).clear();
    driver.findElement(By.id("id_last_name")).sendKeys("Guide");
    driver.findElement(By.id("id_username")).clear();
    driver.findElement(By.id("id_username")).sendKeys("selTestGuide");
    driver.findElement(By.id("id_email")).clear();
    driver.findElement(By.id("id_email")).sendKeys("test@guide.com");
    driver.findElement(By.id("id_password")).clear();
    driver.findElement(By.id("id_password")).sendKeys("test1");
    Thread.sleep(3000);
    driver.findElement(By.id("user_form")).submit();
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
