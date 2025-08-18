package tests;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void canCreateContact() {
        if (!isAddNewPage()) {
            //в canRemoveContact используется openPage("home"), поэтому эта конструкция if не объединена в один метод
            openPage("add new");
        }
        createContact("firstName", "lastName", "phoneNumber");
    }

    @Test
    public void canCreateContactWithAllEmptyProperties() {
        if (!isAddNewPage()) {
            openPage("add new");
        }
        createContact("","","");
    }
}