package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroupWithAllProperties() {
        //считает кол-во групп до создания новой
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new Group("With All Properties", "header", "footer"));
        //считает кол-во групп после создания новой
        int newGroupCount = app.groups().getCount();
        //проверка:значение "до" + 1 = значение "после"
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("With Name Only");
        app.groups().createGroup(groupWithName);
    }
}