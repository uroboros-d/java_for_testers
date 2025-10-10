package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCreationTests extends TestBase {

    public static List<Group> groupProvider() throws IOException {
        var result = new ArrayList<Group>();
//        for(var name: List.of("", "name")){
//            for(var header: List.of("", "header")){
//                for(var footer: List.of("", "footer")){
//                    result.add(new Group()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }

        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<Group>>(){});
        result.addAll(value);
        return result;
    }

    public static Stream<Group> randomGroups() {
        Supplier<Group> randomGroup = ( )->
            new Group()
                    .withName(CommonFunctions.randomString(10))
                    .withHeader(CommonFunctions.randomString(10))
                    .withFooter(CommonFunctions.randomString(10));

        return Stream.generate(randomGroup).limit(1);
    }

    @ParameterizedTest
    @MethodSource("randomGroups")  //указана вспомогат ф-ция выше
    public void canCreateGroup(Group group) {
        //получаем старый список групп
        var oldGroups = app.hbm().getGroupList();
        //создаем новую группу
        app.groups().createGroup(group);
        //получаем новый список групп
        var newGroups = app.hbm().getGroupList();
        var maxId = newGroups.get(newGroups.size() - 1).id();

        //строим список групп, которые не встречались в старом
        var extraGroups = newGroups.stream().filter(g -> ! oldGroups.contains(g)).toList();
        var newId = extraGroups.get(0).id();

        //из старого списка строим ожидаемое значение
        var expectedList = new ArrayList<>(oldGroups);
        //в конец старого списка добавляется новая группа
        expectedList.add(group.withId(maxId));
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }

//    @ParameterizedTest
//    @MethodSource("singleRandomGroup")  //указана вспомогат ф-ция выше
//    public void canCreateGroup(Group group) {
//        //получаем старый список групп
//        var oldGroups = app.jdbc().getGroupList();
//        //создаем новую группу
//        app.groups().createGroup(group);
//        //получаем новый список групп
//        var newGroups = app.jdbc().getGroupList();
//        //сортируем новую группу
//        Comparator<Group> compareById = (o1, o2) -> {
//            //compare вернет 1,если первый объект больше
//            //вернет -1,если первый объект меньше
//            //вернет 0,если объекты равны
//            //сравниваем идентификаторы групп, но они строки, поэтому парсим их в числа
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
//        };
//        newGroups.sort(compareById);
//        var maxId = newGroups.get(newGroups.size() - 1).id();
//
//        //из старого списка строим ожидаемое значение
//        var expectedList = new ArrayList<>(oldGroups);
//        //в конец старого списка добавляется новая группа
//        expectedList.add(group.withId(maxId));
//        expectedList.sort(compareById);
//        Assertions.assertEquals(newGroups, expectedList);
//
//        //var newUiGroups = app.groups().getList();
//    }

    public static List<Group> negativeGroupProvider() {
        //result будет списком объектов типа Group
        var result = new ArrayList<>(List.of(
                new Group("", "group name'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")  //указана вспомогат ф-ция выше
    public void canNotCreateGroup(Group group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups, oldGroups);
    }
}