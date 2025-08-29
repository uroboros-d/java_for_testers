package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<Contact> contactProvider() {
        var result = new ArrayList<Contact>();
        for (var firstname : List.of("", "firstname")) {
            for (var lastname : List.of("", "lastname")) {
                for (var address : List.of("", "address")) {
                    for (var email : List.of("", "email")) {
                        for (var mobile : List.of("", "mobile")) {
                            result.add(new Contact().withFirstame(firstname).withLastame(lastname).withAddress(address).withEmail(email).withMobile(mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            //добавл-ся i<5 объектов типа Contact с случ сгенерир именем и фамилией
            result.add(new Contact().withFirstame("random " + randomString(i * 10)).withLastame("random " + randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")  //указана вспомогат ф-ция выше
    public void canCreateMultipleContacts(Contact contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
}