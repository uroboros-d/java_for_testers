package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

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
                    "1111111",
                    "email@email.com"));
        }
        var oldContacts = app.contacts().getList();
        //выбираем случайный индекс в диапазоне 0-oldContacts.size()
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        //модифицируем контакт с случ индексом index
        var testData = new Contact()
                .withLastname("Modified lastname")
                .withFirstname("Modified firstname")
                .withAddress("Modified address")
                .withEmail("modifiedEmail@email.com")
                .withMobile("1234567890");
        app.contacts().modifyContact(oldContacts.get(index),
                testData);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        var newContacts = app.contacts().getList();
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
}
