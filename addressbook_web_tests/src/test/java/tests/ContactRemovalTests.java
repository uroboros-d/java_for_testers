package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app1.contacts().isContactPresent()) {
            app1.contacts().goToAddNewPage();
            app1.contacts().createContact(new Contact(
                    "firstName",
                    "middleName",
                    "lastName",
                    "nickName",
                    "title",
                    "company",
                    "address",
                    "homePhone",
                    "mobilePhone",
                    "workPhone",
                    "fax",
                    "email",
                    "email2",
                    "email3",
                    "homepage"
            ));
        }
        app1.contacts().removeContact();
    }
}