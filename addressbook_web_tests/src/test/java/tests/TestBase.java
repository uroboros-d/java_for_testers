package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

//общий базовый класс для всех тестов для хранения повторяющегося кода
public class TestBase {

    //объявление ссылки на ApplicationManager - менеджер управления приложением
    protected static ApplicationManager app;

    @BeforeEach
    // в setUp выполняются предусловия
    public void setUp() {
        //инициализация ссылки на ApplicationManager
        if (app == null) {      // если инициализация еще не выполнялась
            app = new ApplicationManager();
        }
        //приложение запускать в браузере, указанном в browser, или в дефолтном firefox
        app.init(System.getProperty("browser", "chrome"));
    }
}