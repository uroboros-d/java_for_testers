package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    //возвращает список объектов типа Group
    public static List<Group> groupProvider() {
        //result будет списком объектов типа Group
        var result = new ArrayList<Group>(List.of(
                new Group("group name", "", ""),
                new Group("group name'", "", "")));
        for(int i=0;i<5;i++) {
            //добавл-ся объекты типа Group с случ сгенерир именем, хэдером и футером
            result.add(new Group(randomString(i*10), randomString(i*10), randomString(i*10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")  //указана вспомогат ф-ция выше
    public void canCreateMultipleGroups(Group group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
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