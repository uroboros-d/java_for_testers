package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("test", "test header", "test footer"));
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
