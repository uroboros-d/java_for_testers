package manager;

import jdk.nio.zipfs.ZipFileAttributeView;
import model.Contact;
import model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(Contact contact) {
        goToAddNewPage();
        fillContactForm(contact);
        submitContactCreation();
        goToHomePage();
    }

    public void createContact(Contact contact, Group group) {
        goToAddNewPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        goToHomePage();
    }

    private void selectGroup(Group group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void removeContact(Contact contact) {
        goToHomePage();
        selectContact(contact);
        removeSelectedContact();
        goToHomePage();
    }

    public void modifyContact(Contact contact, Contact modifiedContact) {
        goToHomePage();
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        goToHomePage();
    }

    public void goToAddNewPage() {
        if (!manager.isElementPresent(By.name("lastname"))) {
            click(By.linkText("add new"));
        }
    }

    private void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());
        type(By.name("company"), contact.company());
//        attach(By.name("photo"), contact.photo());
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void goToHomePage() {
        if (!manager.isElementPresent(By.cssSelector("input[value='Delete']"))) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Pause");
            }
            click(By.linkText("home"));
        }
    }

    private void selectContact(Contact contact) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        click(By.cssSelector(String.format("input[id='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCount() {
        //функция возвращает список найденных элементов,
        //но нас интересует их кол-во, поэтому используем функцию size()
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<Contact> getList() {
        goToHomePage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        //пустой список, куда будем складывать контакты
        var contacts = new ArrayList<Contact>();
        //список элементов tr,найденных по name
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var cells = tr.findElements(By.tagName("td"));
            var id = cells.get(0).findElement(By.tagName("input")).getAttribute("id");
            var lastname = cells.get(1).getText();
            var firstname = cells.get(2).getText();
            var address = cells.get(3).getText();
            //имейл не считываю, чтобы при сравнении не решать проблему с пустой и непустой ячейкой имейла
            var phone = cells.get(5).getText();
            contacts.add(new Contact()
                    .withId(id)
                    .withLastname(lastname)
                    .withFirstname(firstname)
                    .withAddress(address)
                    .withMobile(phone));
        }
        return contacts;
    }

    private void initContactModification(Contact contact) {
        // Формируем XPath выражение для поиска необходимого элемента
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
        String xpathExpression ="//tr[td/input[@name='selected[]' and @value='" + contact.id()
                + "']]" + "/td[a/img[@title='Edit']]";
        click(By.xpath(xpathExpression));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

}