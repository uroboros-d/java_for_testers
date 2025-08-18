package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new Group("test", "test header", "test footer"));
        }
        app.groups().removeGroup();
    }
}
