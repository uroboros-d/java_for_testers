package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class ContactCreationTests {
    //
    private static WebDriver driver1;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    // перед тестом нужно запустить браузер, используя соответствующий драйвер
    public void setUp() {
        if(driver1 == null) {               //проверка предусловий тестов
            driver1 = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver1::quit));
            driver1.get("http://localhost/addressbook/");
            driver1.manage().window().setSize(new Dimension(862, 680));
            driver1.findElement(By.name("user")).sendKeys("admin");
            driver1.findElement(By.name("pass")).sendKeys("secret");
            driver1.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    @Test
    public void canCreateContact() {
        driver1.findElement(By.linkText("add new")).click();
        driver1.findElement(By.name("firstname")).sendKeys("dz");
        driver1.findElement(By.name("lastname")).sendKeys("dz");
        driver1.findElement(By.name("mobile")).sendKeys("123");
        driver1.findElement(By.xpath("//input[@value=\'Enter\']")).click();
        driver1.findElement(By.linkText("home page")).click();
    }

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        driver1.findElement(By.linkText("add new")).click();
        driver1.findElement(By.xpath("//input[@value=\'Enter\']")).click();
        driver1.findElement(By.linkText("home page")).click();
    }
}
