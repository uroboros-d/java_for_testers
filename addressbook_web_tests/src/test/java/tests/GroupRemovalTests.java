package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group("test", "test header", "test footer"));
        }
        //кол-во групп до удаления
        int groupCount = app.groups().getCount();
        app.groups().removeGroup();
        int newGroupCount = app.groups().getCount();
        //проверка:значение "до" - 1 = значение "после"
        Assertions.assertEquals(groupCount - 1, newGroupCount);
    }
}
