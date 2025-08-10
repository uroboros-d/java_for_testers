import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        openGroupsPage();                  // перейти на страницу /addressbook/group.php
        createGroup(new GroupData("test", "test header", "test footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();                   // перейти на страницу /addressbook/group.php
        createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        createGroup(groupWithName);
    }
}