package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactCreationTests extends TestBase{

    @Test
    public void canCreateContact() {
        if (! isElementPresent1(By.name("lastname"))) {
            driver1.findElement(By.linkText("add new")).click();
        }
        createContact("dz", "dz", "123");
    }

    private static void createContact(String firstname, String lastname, String mobile) {
        driver1.findElement(By.name("firstname")).sendKeys(firstname);
        driver1.findElement(By.name("lastname")).sendKeys(lastname);
        driver1.findElement(By.name("mobile")).sendKeys(mobile);
        driver1.findElement(By.name("submit")).click();
        driver1.findElement(By.linkText("home page")).click();
    }

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        if (! isElementPresent1(By.name("lastname"))) {
            driver1.findElement(By.linkText("add new")).click();
        }
        createContact("", "", "");
    }

}
