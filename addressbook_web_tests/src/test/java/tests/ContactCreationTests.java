package tests;
import model.Contact;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContactCreationTests extends TestBase{

    @Test
    public void canCreateContactWithAllStringProperties() {
        if (!isAddNewPage()) {
            //в canRemoveContact используется openPage("home"), поэтому эта конструкция if не объединена в один метод
            openPage("add new");
        }
        createContact(new Contact(
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

//    @Test
//    public void canCreateContactWithAllEmptyProperties() {
//        if (!isAddNewPage()) {
//            openPage("add new");
//        }
//        createContact(new Contact("", "", ""));
//    }
}