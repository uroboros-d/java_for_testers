package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithAllStringProperties() {
        app.contacts().createContact(new Contact(
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

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        app.contacts().createContact(new Contact());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new Contact().withName("some name"));
    }

    @Test
    public void canCreateContactWithFiveProperties() {
        app.contacts().createContact(new Contact().withFiveProperties("firstname", "lastname", "address", "email", "mobile"));
    }
}
