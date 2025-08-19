package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app1.isHomePage()) {
            app1.openPage("home");
        }
        if (!app1.isContactPresent()) {
            app1.openPage("add new");
            app1.createContact(new Contact(
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
        app1.removeContact();
    }
}