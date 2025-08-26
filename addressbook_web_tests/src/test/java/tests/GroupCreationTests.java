package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<Group> groupProvider() {
        //result будет списком объектов типа Group
        var result = new ArrayList<Group>();
        //перебирает 2 комбинации названия
        for(var name: List.of("", "name")){
            for(var header: List.of("", "header")){
                for(var footer: List.of("", "footer")){
                    result.add(new Group()
                            .withName(name)
                            .withHeader(header)
                            .withFooter(footer));
                }
            }
        }
        for(int i=0;i<5;i++) {
            //вызывается конструктор без параметров, а потом создаются объекты с модиф св-ми
            result.add(new Group()
                    .withName("random " + randomString(i*10))       //созд-ся объект с именем с ранд строкой
                    .withHeader("random " + randomString(i*10))     //созд-ся объект с хэдером с ранд строкой
                    .withFooter("random " + randomString(i*10)));   //созд-ся объект с футером с ранд строкой
        }
        //в этом случае при изменении конструктора (т.е. при добавлении новых свойств) код в этом месте меняться не будет
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

    public static List<Group> negativeGroupProvider() {
        //result будет списком объектов типа Group
        var result = new ArrayList<>(List.of(
                new Group("", "group name'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")  //указана вспомогат ф-ция выше
    public void canNotCreateGroup(Group group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}