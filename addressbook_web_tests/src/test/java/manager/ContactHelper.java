package manager;

import model.Contact;
import org.openqa.selenium.By;

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
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
}