package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//общий базовый класс для всех тестов для хранения повторяющегося кода
public class TestBase {

    //объявление ссылки на ApplicationManager - мереджер управления приложением
    protected static ApplicationManager app;
    //объявление переменной, с помощью которой будет запускаться браузер
    protected WebDriver driver1;

    @BeforeEach
    // в setUp выполняются предусловия
    public void setUp() {
        //инициализация ссылки на ApplicationManager
        if (app == null) {      // если инициализация еще не выполнялась
            app = new ApplicationManager();
        }
        //приложение запускать в браузере, указанном в browser, или в дефолтном firefox
        app.init(System.getProperty("browser", "firefox"));
    }

    @BeforeEach
    // перед тестом нужно запустить браузер, используя соответствующий драйвер
    public void setUp1() {
        if (driver1 == null) {               //проверка предусловий тестов
            driver1 = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver1::quit));
            driver1.get("http://localhost/addressbook/");
            driver1.manage().window().setSize(new Dimension(862, 680));
            driver1.findElement(By.name("user")).sendKeys("admin");
            driver1.findElement(By.name("pass")).sendKeys("secret");
            driver1.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    protected boolean isElementPresent1(By locator) {
        try {
            driver1.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void createContact(String firstname, String lastname, String mobile) {
        driver1.findElement(By.name("firstname")).sendKeys(firstname);
        driver1.findElement(By.name("lastname")).sendKeys(lastname);
        driver1.findElement(By.name("mobile")).sendKeys(mobile);
        driver1.findElement(By.name("submit")).click();
    }

    protected void openHomePage() {
        //кликнуть на ссылку home
        driver1.findElement(By.linkText("home")).click();
    }

    protected boolean homePageIsOpened() {
        //если на странице есть кнопка Delete, то это страница home
        return isElementPresent1(By.cssSelector("input[value='Delete']"));
    }

    protected void openAddNewPage() {
        //кликнуть на ссылку add new
        driver1.findElement(By.linkText("add new")).click();
    }

    protected boolean addNewPageIsOpened() {
        //если на странице есть поле lastname, то это страница add new
        return isElementPresent1(By.name("lastname"));
    }


}