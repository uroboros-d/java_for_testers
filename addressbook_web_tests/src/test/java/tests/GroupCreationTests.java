package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

//расширяет TestBase, наследуя его переменные и методы
public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new GroupData("test", "test header", "test footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.groups().createGroup(groupWithName);
    }
}