package tests;

import model.Group;
import org.junit.jupiter.api.Test;

//расширяет TestBase, наследуя его переменные и методы
public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroupWithAllProperties() {
        app.groups().createGroup(new Group("With All Properties", "header", "footer"));
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