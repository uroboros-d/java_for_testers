import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup("group two", "group two header", "group two footer");
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup("", "", "");
    }
}