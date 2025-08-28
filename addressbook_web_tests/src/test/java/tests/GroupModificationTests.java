package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group("", "With All Properties", "header", "footer"));
        }
        var oldGroups = app.groups().getList();
        //в старом списке берем какой-то объект, который будет соответствовать удаляемой группе
        //для этого используем генератор случайных чисел
        var rnd = new Random();
        //выбираем какой-нибудь индекс в диапазоне от 0 до oldGroups.size()
        //т.е. случайно выбираем индекс какого-то элемента из списка oldGroups
        var index = rnd.nextInt(oldGroups.size());
        //modifyGroup принимает 2 параметра: группа для модификации, данные для заполнения формы при модификации группы
        var testData = new Group().withName("Modified Name");
        app.groups().modifyGroup(oldGroups.get(index), testData);
        //после модификации загружаем новый список групп
        var newGroups = app.groups().getList();
        //строим ожидаемое значение
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        //сейчас оба списка отсортируем по идентификаторам
        //o1 и о2 - 2 параметра ф-ции типа Group
        Comparator<Group> compareById = (o1, o2) -> {
            //compare вернет 1,если первый объект больше
            //вернет -1,если первый объект меньше
            //вернет 0,если объекты равны
            //сравниваем идентификаторы групп, но они строки, поэтому парсим их в числа
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }
}