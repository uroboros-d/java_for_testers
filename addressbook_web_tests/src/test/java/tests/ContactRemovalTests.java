package tests;

import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase{

    @Test
    public void canRemoveContact() {
        if (!isHomePage()) {
            openPage("home");
        }
        if(!isContactPresent()) {
            openPage("add new");
            createContact("firstName", "lastName", "phoneNumber");
        }
        removeContact();
    }
}

