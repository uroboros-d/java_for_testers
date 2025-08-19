package tests;

import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithAllStringProperties() {
        if (!app1.isAddNewPage()) {
            //в canRemoveContact используется openPage("home"), поэтому эта конструкция if не объединена в один метод
            app1.openPage("add new");
        }
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

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        if (!app1.isAddNewPage()) {
            app1.openPage("add new");
        }
        app1.createContact(new Contact());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        if (!app1.isAddNewPage()) {
            app1.openPage("add new");
        }
        //создается первый контакт с пустыми полями, а потом метод создает
        //второй контакт с полями первого и заполняет поле name значением some name
        app1.createContact(new Contact().withName("some name"));
    }

    @Test
    public void canCreateContactWithFiveProperties() {
        if (!app1.isAddNewPage()) {
            app1.openPage("add new");
        }
        //создается первый контакт с пустыми полями, а потом метод создает
        //второй контакт с полями первого и заполняет поле name значением some name
        app1.createContact(new Contact().withFiveProperties("firstname", "lastname", "address", "email", "mobile"));
    }
}
