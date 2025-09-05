package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<Contact> contactProvider() {
        var result = new ArrayList<Contact>();
        for (var firstname : List.of("", "firstname")) {
            for (var lastname : List.of("", "lastname")) {
                for (var address : List.of("", "address")) {
                    for (var email : List.of("", "email")) {
                        for (var mobile : List.of("", "mobile")) {
                            result.add(new Contact()
                                    .withFirstname(firstname)
                                    .withLastname(lastname)
                                    .withAddress(address)
                                    .withEmail(email)
                                    .withMobile(mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            //добавл-ся i<5 объектов типа Contact с случ сгенерир именем и фамилией
            result.add(new Contact().withFirstname(randomString(i * 10)).withLastname(randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")  //указана вспомогат ф-ция выше
    public void canCreateMultipleContacts(Contact contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<Contact> compareById = (o1, o2) -> {
            //compare вернет 1,если первый объект больше
            //вернет -1,если первый объект меньше
            //вернет 0,если объекты равны
            //сравниваем идентификаторы групп, но они строки, поэтому парсим их в числа
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withEmail(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}