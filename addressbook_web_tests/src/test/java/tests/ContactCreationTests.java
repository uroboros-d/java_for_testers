package tests;

import model.Contact;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<Contact> contactProvider() {
        //result будет списком объектов типа Contact
        var result = new ArrayList<Contact>(List.of(
                new Contact(
                        "AllStringProperties",
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
                ),
                new Contact(),
                new Contact().withName("Only name"),
                new Contact().withFiveProperties("OnlyFiveProperties", "lastname", "address", "email", "mobile")));
        for (var firstname : List.of("", "firstname")) {
            for (var middlename : List.of("", "middlename")) {
                for (var lastname : List.of("", "lastname")) {
                    for (var nickname : List.of("", "nickname")) {
                        for (var title : List.of("", "title")) {
                            for (var company : List.of("", "company")) {
                                for (var address : List.of("", "address")) {
                                    for (var home : List.of("", "home")) {
                                        for (var mobile : List.of("", "mobile")) {
                                            for (var work : List.of("", "work")) {
                                                for (var fax : List.of("", "fax")) {
                                                    for (var email : List.of("", "email")) {
                                                        for (var email2 : List.of("", "email2")) {
                                                            for (var email3 : List.of("", "email3")) {
                                                                for (var homepage : List.of("", "homepage")) {
                                                                    result.add(new Contact((firstname,
                                                                            middlename,
                                                                            lastname,
                                                                            nickname,
                                                                            title,
                                                                            company,
                                                                            address,
                                                                            home,
                                                                            mobile,
                                                                            work,
                                                                            fax,
                                                                            email,
                                                                            email2,
                                                                            email3,
                                                                            homepage
                                                                            ));
                                                                }
                                                            }
                                                        }
                                                for (int i = 0; i < 5; i++) {
                                                    //добавл-ся i<5 объектов типа Contact с случ сгенерир именем
                                                    result.add(new Contact().withName("random " + randomString(i * 10)));
                                                }
                                                return result;
                                            }

                                            @ParameterizedTest
                                            @MethodSource("contactProvider")  //указана вспомогат ф-ция выше
                                            public void canCreateContacts (Contact contact){
                                                int contactCount = app.contacts().getCount();
                                                app.contacts().createContact(contact);
                                                int newContactCount = app.contacts().getCount();
                                                Assertions.assertEquals(contactCount + 1, newContactCount);
                                            }
                                        }