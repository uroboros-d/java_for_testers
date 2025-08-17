package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        //если на текущей странице нет кнопки Delete,
        // то перейти в раздел home
        if (! isElementPresent1(By.cssSelector("input[value='Delete']"))) {
            driver1.findElement(By.linkText("home")).click();
        }
        //если нет ни одного контакта, т.е. нет элемента selected[]
        // - чекбокс перед контактом, то создать контакт
        if(! isElementPresent1(By.name("selected[]"))) {
            driver1.findElement(By.linkText("add new")).click();
            driver1.findElement(By.name("firstname")).sendKeys("dz");
            driver1.findElement(By.name("lastname")).sendKeys("dz");
            driver1.findElement(By.name("mobile")).sendKeys("123");
            driver1.findElement(By.name("submit")).click();
            driver1.findElement(By.linkText("home page")).click();
        }
        driver1.findElement(By.name("selected[]")).click();
        driver1.findElement(By.cssSelector("input[value='Delete']")).click();
    }
}

