package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new Group("", "test name", "test header", "test footer"));
        }
        var oldGroups = app.hbm().getGroupList();
        //в старом списке берем какой-то объект, который будет соответствовать удаляемой группе
        var rnd = new Random();
        //выбираем какой-нибудь индекс в диапазоне от 0 до oldGroups.size()
        var index = rnd.nextInt(oldGroups.size());
        //метод removeGroup будет удалять именно эту группу
        app.groups().removeGroup(oldGroups.get(index));
        //после удаления группы получаем новый список групп
        var newGroups = app.hbm().getGroupList();
        //после удаления группы мы должны построить список, с которым будем сравнивать список newGroups
        //строим копию списка oldGroups
        var expectedList = new ArrayList<>(oldGroups);
        //удаляем элемент с заданным индексом
        expectedList.remove(index);
        //сравниваем списки
        Assertions.assertEquals(newGroups, expectedList);
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new Group("", "test name", "test header", "test footer"));
        }
        app.groups().removeAllGroup();
        Assertions.assertEquals(0, app.groups().getCount());
    }
}
