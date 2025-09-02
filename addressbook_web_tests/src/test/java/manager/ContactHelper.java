package manager;

import model.Contact;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public int getCount() {
        //goToHomePage();
        //функция находит не один элемент, а много и возвращает список найденных элементов,
        //но нас интересует их кол-во, поэтому используем функцию size()
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void createContact(Contact contact) {
        goToAddNewPage();
        fillContactForm(contact);
        submitContactCreation();
        goToHomePage();
    }

    public void removeContact() {
        goToHomePage();
        selectContact();
        removeSelectedContact();
        goToHomePage();
    }

    public void goToAddNewPage() {
        if (!manager.isElementPresent(By.name("lastname"))) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Pause");
            }
            click(By.linkText("add new"));
        }
    }

    private void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());
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

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void removeSelectedContact() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    public List<Contact> getList() {
        //пустой список, куда будем складывать контакты
        var contacts = new ArrayList<Contact>();
        //список элементов tr,найденных по name
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs){
//            var checkbox = tr.findElement(By.name("selected[]"));
//            var id = checkbox.getAttribute("id");
            var cells = tr.findElements(By.tagName("td"));
            var id = cells.get(0).getAttribute("id");
            var lastname = cells.get(1).getText();
            var firstname = cells.get(2).getText();
            contacts.add(new Contact().withId(id).withLastame(lastname).withFirstame(firstname));
        }
        return contacts;
    }
}