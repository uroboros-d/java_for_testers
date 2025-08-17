package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.NoSuchElementException;

public class ContactCreationTests extends TestBase{

    @Test
    public void canCreateContact() {
        if (! isElementPresent1(By.name("lastname"))) {
            driver1.findElement(By.linkText("add new")).click();
        }
        driver1.findElement(By.name("firstname")).sendKeys("dz");
        driver1.findElement(By.name("lastname")).sendKeys("dz");
        driver1.findElement(By.name("mobile")).sendKeys("123");
        driver1.findElement(By.name("submit")).click();
        driver1.findElement(By.linkText("home page")).click();
    }

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        if (! isElementPresent1(By.name("lastname"))) {
            driver1.findElement(By.linkText("add new")).click();
        }
        driver1.findElement(By.xpath("//input[@value=\'Enter\']")).click();
        driver1.findElement(By.linkText("home page")).click();
    }
}
