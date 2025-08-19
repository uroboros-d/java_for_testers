package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//класс, в котором будут методы для управления тестируемым приложением
public class ApplicationManager {

    //переменная для запуска браузера
    protected WebDriver driver;
    //
    private LoginHelper session;
    //
    private GroupHelper groups;

    //метод инициализации driver, открытия браузера, открытия в браузере нужной страницы, логина, закрытия браузера
    public void init(String browser) {
        if(driver == null) {
            if("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if("chrome".equals(browser)) {
                 driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(854, 694));
            session().login("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }


}
