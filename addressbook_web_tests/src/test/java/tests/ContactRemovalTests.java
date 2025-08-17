package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        //если текущая страница не home, то перейти в раздел home
        if (!homePageIsOpened()) {
            openHomePage();
        }
        //если нет ни одного контакта, т.е. нет элемента selected[]
        // - чекбокс перед контактом, то создать контакт
        if(!isContactPresent()) {
            openAddNewPage();
            createContact("dz", "dz", "123");
        }
        removeContact();
    }

    private boolean isContactPresent() {
        return isElementPresent1(By.name("selected[]"));
    }

    private void removeContact() {
        driver1.findElement(By.name("selected[]")).click();
        driver1.findElement(By.cssSelector("input[value='Delete']")).click();
    }
}

