package manager;

import model.Contact;
import org.openqa.selenium.By;

public class ContactHelper {
    private final ApplicationManager1 manager1;

    public ContactHelper(ApplicationManager1 manager1) {
        this.manager1 = manager1;
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
        if (! manager1.isElementPresent1(By.name("lastname"))) {
            manager1.driver1.findElement(By.linkText("add new")).click();
        }
    }

    private void fillContactForm(Contact contact) {
        manager1.driver1.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager1.driver1.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager1.driver1.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager1.driver1.findElement(By.name("nickname")).sendKeys(contact.nickname());
        manager1.driver1.findElement(By.name("title")).sendKeys(contact.title());
        manager1.driver1.findElement(By.name("company")).sendKeys(contact.company());
        manager1.driver1.findElement(By.name("address")).sendKeys(contact.address());
        manager1.driver1.findElement(By.name("home")).sendKeys(contact.home());
        manager1.driver1.findElement(By.name("mobile")).sendKeys(contact.mobile());
        manager1.driver1.findElement(By.name("work")).sendKeys(contact.work());
        manager1.driver1.findElement(By.name("fax")).sendKeys(contact.fax());
        manager1.driver1.findElement(By.name("email")).sendKeys(contact.email());
        manager1.driver1.findElement(By.name("email2")).sendKeys(contact.email2());
        manager1.driver1.findElement(By.name("email3")).sendKeys(contact.email3());
        manager1.driver1.findElement(By.name("homepage")).sendKeys(contact.homepage());
    }

    private void submitContactCreation() {
        manager1.driver1.findElement(By.name("submit")).click();
    }

    private void goToHomePage() {
        if (!manager1.isElementPresent1(By.cssSelector("input[value='Delete']"))) {
            manager1.driver1.findElement(By.linkText("home")).click();
        }
        //без использования задержки при запуске класса с тестами создания 1 тест выполн-ся успешно,
        // а остальные падают с ошибкой "Unable to locate element: add new"
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Pause");
        }
    }

    private void selectContact() {
        manager1.driver1.findElement(By.name("selected[]")).click();
    }

    private void removeSelectedContact() {
        manager1.driver1.findElement(By.cssSelector("input[value='Delete']")).click();
    }

    public boolean isContactPresent() {
        return manager1.isElementPresent1(By.name("selected[]"));
    }

//    public boolean isAddNewPage() {
//        return manager1.isElementPresent1(By.name("lastname"));
//    }

//    public boolean isHomePage() {
//        return manager1.isElementPresent1(By.cssSelector("input[value='Delete']"));
//    }
}
