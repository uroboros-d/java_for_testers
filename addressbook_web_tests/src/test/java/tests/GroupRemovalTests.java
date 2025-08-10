package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        app.groups.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("test", "test header", "test footer"));
        }
        app.removeGroup();
    }
}
