package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().goToAddNewPage();
            app.hbm().createContact(new Contact(
                     "",
                    "firstName",
                    "middleName",
                    "lastName",
                    "company",
                    "address",
                    "mobilePhone",
                    "email",
                    "src/test/resources/imagesJava/avatar.jpg"
//порядок полей в коде должен быть как порядок полей в табл бд
                    )
            );
        }
        //ф-ция возвращает список объектов типа Contact
        var oldContacts = app.hbm().getContactList();
        //в старом списке выбираем рандомный контакт, подлежащий удалению
        //создаем генератор случ чисел
        var rnd = new Random();
        //выбираем случайный индекс в диапазоне 0-oldContacts.size()
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        //пауза, иначе не отрисовывается и newContacts пустой
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        //после удаления получаем новый список групп
        var newContacts = app.hbm().getContactList();
        //после удаления нужно построить список, с которым будем сравниввть список newContacts
        var expectedList = new ArrayList<>(oldContacts);
        //удаляем элемент с заданным индексом
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
}