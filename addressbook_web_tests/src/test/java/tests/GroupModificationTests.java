package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group("With All Properties", "header", "footer"));
        }
        app.groups().modifyGroup(new Group().withName("Modified Name"));
    }
}
