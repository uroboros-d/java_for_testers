package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

//класс, в котором будут методы для управления тестируемым приложением
public class ApplicationManager {

    //ссылка для запуска браузера
    protected WebDriver driver;
    //ссылка для управления сессией
    private LoginHelper session;
    //ссылка для управления группой
    private GroupHelper groups;
    //ссылка для управления контактом
    private ContactHelper contacts;

    private Properties properties;

    private JdbcHelper jdbc;

    //метод инициализации driver, открытия браузера, открытия в браузере нужной страницы, логина, закрытия браузера
    public void init(String browser, Properties properties) {
        this.properties = properties;
        if (driver == null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            }
            else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(854, 694));
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));
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

    public ContactHelper contacts() {
        if (contacts == null) {
            contacts = new ContactHelper(this);
        }
        //если уже проинициализирован, то внутрь if не попадаем, а сразу возвращаем ссылку на помощника
        return contacts;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public JdbcHelper jdbc() {
        if (jdbc == null) {
            jdbc = new JdbcHelper(this);
        }
        //если уже проинициализирован, то внутрь if не попадаем, а сразу возвращаем ссылку на помощника
        return jdbc;
    }
}