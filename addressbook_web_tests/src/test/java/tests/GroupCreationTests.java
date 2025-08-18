package tests;

import model.Group;
import org.junit.jupiter.api.Test;

//расширяет TestBase, наследуя его переменные и методы
public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new Group("test", "test header", "test footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new Group());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("some name");
        app.groups().createGroup(groupWithName);
    }
}