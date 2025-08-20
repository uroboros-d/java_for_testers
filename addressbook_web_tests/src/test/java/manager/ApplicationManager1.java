package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ApplicationManager1 {
    //объявление переменной, с помощью которой будет запускаться браузер
    protected WebDriver driver1;

    private LoginHelper1 session1;

    public ContactHelper contacts;

    public void init1(String browser) {
        if (driver1 == null) {               //проверка предусловий тестов
            if("firefox".equals(browser)){
                driver1 = new FirefoxDriver();
            } else if ("chrome".equals(browser)){
                driver1 = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver1::quit));
            driver1.get("http://localhost/addressbook/");
            driver1.manage().window().setSize(new Dimension(862, 680));
            session1().login1("admin", "secret");
        }
    }

    public LoginHelper1 session1() {
        if (session1 == null) {
            session1 = new LoginHelper1(this);
        }
        //если уже проинициализирован, то внутрь if не попадаем, а сразу возвращаем ссылку на помощника
        return session1;
    }

    public ContactHelper contacts() {
        if (contacts == null) {
            contacts = new ContactHelper(this);
        }
        //если уже проинициализирован, то внутрь if не попадаем, а сразу возвращаем ссылку на помощника
        return contacts;
    }

    public boolean isElementPresent1(By locator) {
        try {
            driver1.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
