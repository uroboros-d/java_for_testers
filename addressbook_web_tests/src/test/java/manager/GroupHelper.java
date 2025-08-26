package manager;

import model.Group;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createGroup(Group group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(Group modifiedGroup) {
        openGroupsPage();               //открыть страницу со списком групп
        selectGroup();                  //выбрать группу - отметить ее галочкой
        initGroupModification();        //нажать кнопку модификации
        fillGroupForm(modifiedGroup);   //заполнить форму данными из объекта. переданного в кач-ве параметра в метод
        submitGroupModification();      //нажать кнопку подтверждения изменения
        returnToGroupsPage();           //вернуться на страницу со списком групп
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removeSelectedGroups() {
        click(By.name("delete"));
    }

    private void returnToGroupsPage() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(Group group) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    public int getCount() {
        openGroupsPage();
        //функция находит не один элемент, а много и возвращает список найденных элементов,
        //но нас интересует их кол-во, поэтому используем функцию size()
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroup() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        //пробегает по всем элементам checkbox коллекции checkboxes и кликает на них
        for (var checkbox: checkboxes) {
            checkbox.click();
        }
    }

    public List<Group> getList() {
        //пустой список, в который будем складывать группы
        var groups = new ArrayList<Group>();
        //ищем элементы по селектору - ищем по всей странице элементы с тэгом span, которые имеют класс group
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        //устраиваем цикл по найденным элементам
        for(var span : spans){
            //получаем название группы
            var name = span.getText();
            //находим чекбокс, выполняя поиск внутри элемента span по имени "selected[]"
            var checkbox = span.findElement(By.name("selected[]"));
            //получаем из чекбокса идентификатор (получить значение атрибута value)
            var id = checkbox.getAttribute("value");
            //добавить в список групп новый объект с заданным именем и идентификатором
            groups.add(new Group().withId(id).withName(name));
        }
        return groups;
    }
}