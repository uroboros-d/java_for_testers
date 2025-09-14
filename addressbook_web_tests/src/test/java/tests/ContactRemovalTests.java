package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().goToAddNewPage();
            app.contacts().createContact(new Contact(
                            "",
                            "firstName",
                            "lastName",
                            "address",
                            "mobilePhone",
                            "email",
                            "src/test/resources/imagesJava/avatar.jpg"
                    )
            );
        }
        //ф-ция возвращает список объектов типа Contact
        var oldContacts = app.contacts().getList();
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
        var newContacts = app.contacts().getList();
        //после удаления нужно построить список, с которым будем сравниввть список newContacts
        //делаем копию старого списка
        var expectedList = new ArrayList<>(oldContacts);
        //удаляем элемент с заданным индексом
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
}