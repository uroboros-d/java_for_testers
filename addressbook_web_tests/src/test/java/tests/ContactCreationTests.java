package tests;

import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void canCreateContact() {
        if (!addNewPageIsOpened()) {
            openAddNewPage();
        }
        createContact("dz", "dz", "123");
    }

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        if (!addNewPageIsOpened()) {
            openAddNewPage();
        }
        createContact("", "", "");
    }
}
