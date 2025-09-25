package tests;

import common.CommonFunctions;
import model.Contact;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests  extends TestBase {

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new Contact(
                            "",
                            "firstName",
                            "middleName",
                            "lastName",
                            "company",
                            "address",
                            "mobilePhone",
                            "email",
                            ""
//порядок полей в коде должен быть как порядок полей в табл бд
                    )
            );
        }
        var oldContacts = app.hbm().getContactList();
        //выбираем случайный индекс в диапазоне 0-oldContacts.size()
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        //модифицируем контакт с случ индексом index
        var testData = new Contact()
                .withLastname(CommonFunctions.randomString(10))
                .withMiddlename(CommonFunctions.randomString(10))
                .withFirstname(CommonFunctions.randomString(10))
                .withCompany(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
                .withEmail(CommonFunctions.randomString(10))
                .withMobile(CommonFunctions.randomString(10))
                .withPhoto("")
                ;
        app.contacts().modifyContact(oldContacts.get(index),
                testData);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<Contact> compareById = (o1, o2) -> {
            //compare вернет 1,если первый объект больше
            //вернет -1,если первый объект меньше
            //вернет 0,если объекты равны
            //сравниваем идентификаторы групп, но они строки, поэтому парсим их в числа
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canAddContactToGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new Contact(
                    "",
                    "firstName",
                    "middleName",
                    "lastName",
                    "company",
                    "address",
                    "mobilePhone",
                    "email",
                    ""
            ));
        }
        var contact = app.hbm().getContactList().get(0);

        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new Group("", "test name", "test header", "test footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().addContactToGroup(group, contact);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() +1 , newRelated.size());
    }
}
