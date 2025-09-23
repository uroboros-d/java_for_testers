package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.Contact;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<Contact> contactProvider() throws IOException {
        var result = new ArrayList<Contact>();
//        for (var firstname : List.of("", "firstname")) {
//            for (var lastname : List.of("", "lastname")) {
//                for (var address : List.of("", "address")) {
//                    for (var email : List.of("", "email")) {
//                        for (var mobile : List.of("", "mobile")) {
//                            result.add(new Contact()
//                                    .withFirstname(firstname)
//                                    .withLastname(lastname)
//                                    .withAddress(address)
//                                    .withEmail(email)
//                                    .withMobile(mobile));
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            //добавл-ся i<5 объектов типа Contact с случ сгенерир именем и фамилией
//            result.add(new Contact().withFirstname(CommonFunctions.randomString(i * 10)).withLastname(CommonFunctions.randomString(i * 10)));
//        }

        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<Contact>>(){});
        result.addAll(value);
        return result;
    }

    public static List<Contact> singleRandomContact() {
        return List.of(new Contact()
                .withFirstname(CommonFunctions.randomString(10))
                .withMiddlename(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withEmail(CommonFunctions.randomString(10))
                .withCompany(CommonFunctions.randomString(10))
                .withMobile(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
//                .withPhoto(randomFile("src/test/resources/imagesJava/avatar.jpg"))
        );
    }

        @ParameterizedTest
    @MethodSource("singleRandomContact")  //указана вспомогат ф-ция выше
    public void canCreateContact(Contact contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<Contact> compareById = (o1, o2) -> {
            //compare вернет 1,если первый объект больше
            //вернет -1,если первый объект меньше
            //вернет 0,если объекты равны
            //сравниваем идентификаторы групп, но они строки, поэтому парсим их в числа
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var maxId = newContacts.get(newContacts.size() - 1).id();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(maxId).withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

     void canCreateContactInGroup() {
        var contact = new Contact()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/imagesJava/avatar.jpg"));
         if (app.hbm().getGroupCount() == 0) {
             app.hbm().createGroup(new Group("", "test name", "test header", "test footer"));
         }
         var group = app.hbm().getGroupList().get(0);

         var oldRelated = app.hbm().getContactsInGroup(group);
         app.contacts().createContact(contact, group);
         var newRelated = app.hbm().getContactsInGroup(group);
         Assertions.assertEquals(oldRelated.size() +1 , newRelated.size());
     }

    //    @ParameterizedTest
//    @MethodSource("contactProvider")  //указана вспомогат ф-ция выше
//    public void canCreateMultipleContacts(Contact contact) {
//        var oldContacts = app.contacts().getList();
//        app.contacts().createContact(contact);
//        var newContacts = app.contacts().getList();
//        Comparator<Contact> compareById = (o1, o2) -> {
//            //compare вернет 1,если первый объект больше
//            //вернет -1,если первый объект меньше
//            //вернет 0,если объекты равны
//            //сравниваем идентификаторы групп, но они строки, поэтому парсим их в числа
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
//        };
//        newContacts.sort(compareById);
//        var expectedList = new ArrayList<>(oldContacts);
//        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withEmail("").withPhoto(""));
//        expectedList.sort(compareById);
//        Assertions.assertEquals(newContacts, expectedList);
//    }

//    @Test
//    void canCreateContact() {
//        var contact = new Contact()
//                .withFirstname(CommonFunctions.randomString(10))
//                .withFirstname(CommonFunctions.randomString(10))
//                .withPhoto(randomFile("src/test/resources/imagesJava/"));
//        app.contacts().createContact(contact);
//    }
}