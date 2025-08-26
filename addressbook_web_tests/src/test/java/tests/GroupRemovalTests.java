package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group("", "test name", "test header", "test footer"));
        }

        int groupCount = app.groups().getCount();
        app.groups().removeGroup();
        List<Group> oldGroups = app.groups().getList();
        int newGroupCount = app.groups().getCount();
        //проверка:значение "до" - 1 = значение "после"
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group("", "test name", "test header", "test footer"));
        }
        app.groups().removeAllGroup();
        Assertions.assertEquals(0, app.groups().getCount());
    }
}
