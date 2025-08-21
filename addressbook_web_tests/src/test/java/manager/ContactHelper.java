package manager;

import model.Contact;
import org.openqa.selenium.By;

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

    public void removeContact() {
        goToHomePage();
        selectContact();
        removeSelectedContact();
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
        type(By.name("nickname"), contact.nickname());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
        type(By.name("fax"), contact.fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homepage());
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void goToHomePage() {
        if (!manager.isElementPresent(By.cssSelector("input[value='Delete']"))) {
            click(By.linkText("home"));
        }
        //без использования задержки тесты падают с ошибкой типа "Unable to locate element: add new"
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
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
}
