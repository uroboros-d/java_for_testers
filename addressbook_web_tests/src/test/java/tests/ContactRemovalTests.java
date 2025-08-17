package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class ContactRemovalTests {
    //объявление переменной, с помощью которой будет запускаться браузер
    private WebDriver driver;

    @BeforeEach
    // перед тестом нужно запустить браузер, используя соответствующий драйвер
    public void setUp() {
        if (driver == null) {               //проверка предусловий тестов
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(862, 680));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    @Test
    public void canRemoveContact() {
        //если на текущей странице нет кнопки Delete,
        // то перейти в раздел home
        if (! isElementPresent(By.cssSelector("input[value='Delete']"))) {
            driver.findElement(By.linkText("home")).click();
        }
        //если нет ни одного контакта, т.е. нет элемента selected[]
        // - чекбокс перед контактом, то создать контакт
        if(! isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("add new")).click();
            driver.findElement(By.name("firstname")).sendKeys("dz");
            driver.findElement(By.name("lastname")).sendKeys("dz");
            driver.findElement(By.name("mobile")).sendKeys("123");
            driver.findElement(By.name("submit")).click();
            driver.findElement(By.linkText("home page")).click();
        }
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.cssSelector("input[value='Delete']")).click();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}

