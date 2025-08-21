package tests;

import manager.ApplicationManager;
//import manager.ApplicationManager1;
import org.junit.jupiter.api.BeforeEach;

//общий базовый класс для всех тестов для хранения повторяющегося кода
public class TestBase {

//    protected static ApplicationManager1 app1;
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
        app.init(System.getProperty("browser", "firefox"));
    }

//    @BeforeEach
//    // перед тестом нужно запустить браузер, используя соответствующий драйвер
//    public void setUp1() {
//        if (app1 == null) {
//            app1 = new ApplicationManager1();
//        }
//        app1.init1(System.getProperty("browser", "firefox"));
//    }
}