package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<String> groupNameProvider() {
        var result = new ArrayList<String>(List.of("group name", "group name'"));
        for(int i=0;i<5;i++) {
            //генерир-ся строка случ символов c увеличивающейся длиной i
            result.add(randomString(i*10));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupNameProvider")  //указана вспомогат ф-ция выше
    public void canCreateMultipleGroups(String name) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new Group(name, "header", "footer"));
        int newGroupCount = app.groups().getCount();
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