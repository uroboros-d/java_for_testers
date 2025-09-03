package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactModificationTests  extends TestBase {

    @Test
    void canModifyContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().goToAddNewPage();
            app.contacts().createContact(new Contact(
                    "",
                    "firstName",
                    "lastName",
                    "address",
                    "mobilePhone",
                    "email"));
        }
        app.contacts().modifyContact(new Contact()
                .withLastname("Modified lastname")
                .withFirstname("Modified firstname")
                .withAddress("Modified address")
                .withEmail("email@email.com")
                .withMobile("Modified phone"));
    }
}
