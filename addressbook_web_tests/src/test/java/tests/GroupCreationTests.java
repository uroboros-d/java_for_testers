package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.groups().openGroupsPage();                  // перейти на страницу /addressbook/group.php
        app.createGroup(new GroupData("test", "test header", "test footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().openGroupsPage();                   // перейти на страницу /addressbook/group.php
        app.createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }
}