package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().goToAddNewPage();
            app.contacts().createContact(new Contact(
                    "", "firstName",
                    "lastName",
                    "address",
                    "mobilePhone",
                    "email"));
        }
        app.contacts().removeContact();
    }
}