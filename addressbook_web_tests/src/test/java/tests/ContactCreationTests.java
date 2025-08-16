package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class ContactCreationTests {

  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @BeforeEach
  // перед тестом нужно запустить браузер, используя соответствующий драйвер
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void canCreateContact() {
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(862, 680));
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).sendKeys("dz");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).sendKeys("dz");
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).sendKeys("123");
    driver.findElement(By.xpath("//input[@value=\'Enter\']")).click();
    driver.findElement(By.linkText("home page")).click();
    driver.findElement(By.xpath("//a[@onclick='document.logout.submit();']")).click();
  }
}
