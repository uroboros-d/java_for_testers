package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        //ф-ция возвращает список объектов типа Contact
        List<Contact> oldContacts = app.contacts().getList();
        app.contacts().removeContact();
    }
}