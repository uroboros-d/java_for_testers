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
        var result = new ArrayList<String>();
        for(int i=0;i<5;i++) {
            //генерир-ся строка случ символов c увеличивающейся длиной i
            result.add(randomString(i*10));
        }
        return result;
    }

    @ParameterizedTest
    //перечисляются значения для параметра name; второе значение с апострофом '
    @ValueSource(strings = {"group name", "group name'"})
    public void canCreateGroupWithAllProperties(String name) {
        //считает кол-во групп до создания новой
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new Group(name, "header", "footer"));
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

    @ParameterizedTest
    @MethodSource("groupNameProvider")
    public void canCreateMultipleGroups() {
        int n = 5;
        int groupCount = app.groups().getCount();

        for(int i=0;i<n;i++) {
            //генерир-ся строка случ символов c увеличивающейся длиной i
            app.groups().createGroup(new Group(randomString(i), "header", "footer"));
        }
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + n, newGroupCount);
    }

}