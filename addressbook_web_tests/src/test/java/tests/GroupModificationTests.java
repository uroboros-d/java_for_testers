package tests;

import common.CommonFunctions;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new Group("", "name", "header", "footer"));
        }
        var oldGroups = app.hbm().getGroupList();
        //в старом списке берем какой-то объект, который будет соответствовать удаляемой группе
        //для этого используем генератор случайных чисел
        var rnd = new Random();
        //выбираем какой-нибудь индекс в диапазоне от 0 до oldGroups.size()
        //т.е. случайно выбираем индекс какого-то элемента из списка oldGroups
        var index = rnd.nextInt(oldGroups.size());
        //modifyGroup принимает 2 параметра: группа для модификации, данные для заполнения формы при модификации группы
        var testData = new Group().withName(CommonFunctions.randomString(10));
        app.groups().modifyGroup(oldGroups.get(index), testData);
        //после модификации загружаем новый список групп
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(expectedList));
    }
}