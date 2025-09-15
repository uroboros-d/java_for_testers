package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

//общий базовый класс для всех тестов для хранения повторяющегося кода
public class TestBase {

    //объявление ссылки на ApplicationManager - менеджер управления приложением
    protected static ApplicationManager app;

    @BeforeEach
    // в setUp выполняются предусловия
    public void setUp() throws IOException {
        //инициализация ссылки на ApplicationManager
        if (app == null) {      // если инициализация еще не выполнялась
            var properties = new Properties();
            //прочесть из файла
            //использовать фиксир значение имени конф файла не вариант
            // - его имя будет меняться когда мы будем менять конфигурай файлы при запуске приложения
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new ApplicationManager();
            //приложение запускать в браузере, указанном в browser, или в дефолтном firefox
            app.init(System.getProperty("browser", "firefox"),properties);
        }
    }

    //принимает путь к директоири, а возвращает путь к рандоному файлу
    public static String randomFile(String dir){
        //получить список файлов из указанной директории
        var fileNames = new File(dir).list();
        //получить случ имя из списка
        var rnd = new Random();
        //получить случ число, не превышающее кол-во файлов
        var index = rnd.nextInt(fileNames.length);
        //соединяем путь и конкретное имя файла
        return Paths.get(dir, fileNames[index]).toString();
    }
}