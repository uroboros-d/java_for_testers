package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {

    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }

    private void removeSelectedGroup() {
        click(By.name("delete"));
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();               //открыть страницу со списком групп
        selectGroup();                  //выбрать группу - отметить ее галочкой
        initGroupModification();        //нажать кнопку модификации
        fillGroupForm(modifiedGroup);   //заполнить форму данными из объекта. переданного в кач-ве параметра в метод
        submitGroupModification();      //нажать кнопку подтверждения изменения
        returnToGroupsPage();           //вернуться на страницу со списком групп
    }

    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).sendKeys(text);
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }
}
