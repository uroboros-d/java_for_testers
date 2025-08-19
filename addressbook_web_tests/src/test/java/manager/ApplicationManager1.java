package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager1 {
    //объявление переменной, с помощью которой будет запускаться браузер
    public static WebDriver driver1;

    public void init1() {
        if (driver1 == null) {               //проверка предусловий тестов
            driver1 = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(ApplicationManager1.driver1::quit));
            driver1.get("http://localhost/addressbook/");
            driver1.manage().window().setSize(new Dimension(862, 680));
            driver1.findElement(By.name("user")).sendKeys("admin");
            driver1.findElement(By.name("pass")).sendKeys("secret");
            driver1.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    public boolean isElementPresent1(By locator) {
        try {
            driver1.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createContact(Contact contact) {
        driver1.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver1.findElement(By.name("middlename")).sendKeys(contact.middlename());
        driver1.findElement(By.name("lastname")).sendKeys(contact.lastname());
        driver1.findElement(By.name("nickname")).sendKeys(contact.nickname());
        driver1.findElement(By.name("title")).sendKeys(contact.title());
        driver1.findElement(By.name("company")).sendKeys(contact.company());
        driver1.findElement(By.name("address")).sendKeys(contact.address());
        driver1.findElement(By.name("home")).sendKeys(contact.home());
        driver1.findElement(By.name("mobile")).sendKeys(contact.mobile());
        driver1.findElement(By.name("work")).sendKeys(contact.work());
        driver1.findElement(By.name("fax")).sendKeys(contact.fax());
        driver1.findElement(By.name("email")).sendKeys(contact.email());
        driver1.findElement(By.name("email2")).sendKeys(contact.email2());
        driver1.findElement(By.name("email3")).sendKeys(contact.email3());
        driver1.findElement(By.name("homepage")).sendKeys(contact.homepage());
        driver1.findElement(By.name("submit")).click();
        driver1.findElement(By.linkText("home page")).click();
    }

    public void openPage(String pageName) {
        driver1.findElement(By.linkText(pageName)).click();
    }

    public boolean isContactPresent() {
        return isElementPresent1(By.name("selected[]"));
    }

    public boolean isAddNewPage() {
        return isElementPresent1(By.name("lastname"));
    }

    public boolean isHomePage() {
        return isElementPresent1(By.cssSelector("input[value='Delete']"));
    }

    public void removeContact() {
        driver1.findElement(By.name("selected[]")).click();
        driver1.findElement(By.cssSelector("input[value='Delete']")).click();
        driver1.findElement(By.linkText("home")).click();
    }
}
