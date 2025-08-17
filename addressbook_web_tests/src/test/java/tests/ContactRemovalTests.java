package tests;

import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        //если текущая страница не home, то перейти в раздел home
        if (!homePageIsOpened()) {
            openHomePage();
        }
        //если нет ни одного контакта, то открыть страницу add new, создать контакт
        if(!isContactPresent()) {
            openAddNewPage();
            createContact("dz", "dz", "123");
        }
        removeContact();
    }
}

