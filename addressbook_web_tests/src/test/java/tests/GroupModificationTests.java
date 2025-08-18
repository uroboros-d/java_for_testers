package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new Group("test", "test header", "test footer"));
        }
        app.groups().modifyGroup(new Group().withName("modified name"));
    }
}
