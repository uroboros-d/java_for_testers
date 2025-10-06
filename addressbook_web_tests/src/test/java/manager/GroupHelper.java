package manager;

import model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void removeGroup(Group group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(Group group, Group modifiedGroup) {
        openGroupsPage();               //открыть страницу со списком групп
        selectGroup(group);                  //выбрать группу - отметить ее галочкой
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

    private void selectGroup(Group group) {
                click(By.cssSelector(String.format("input[value='%s']", group.id())));
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
        //пробегает по всем элементам checkbox коллекции checkboxes и кликает на них
        manager.driver
                .findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

    public List<Group> getList() {
        openGroupsPage();
        //ищем элементы по селектору - ищем по всей странице элементы с тэгом span, которые имеют класс group
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        return spans.stream()
                .map(span -> {
                    //получаем название группы
                    var name = span.getText();
                    //находим чекбокс, выполняя поиск внутри элемента span по имени "selected[]"
                    var checkbox = span.findElement(By.name("selected[]"));
                    //получаем из чекбокса идентификатор (получить значение атрибута value)
                    var id = checkbox.getAttribute("value");
                    return new Group().withId(id).withName(name);
                })
                .collect(Collectors.toList());
    }
}