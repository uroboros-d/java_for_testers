package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

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
        app.init(System.getProperty("browser", "firefox"));
    }

    public static String randomFile(String dir){
        //получить список файлов из указанной директории
        var fileNames = new File(dir).list();
        //получить случ имя из списка
        var rnd = new Random();
        //получить случ чмсло, не превышающее кол-во файлов
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}