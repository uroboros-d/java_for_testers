package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

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

    public static String randomString(int n) {
        //n-желаемая длина генерируемой строки
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            //у каждого символа свой код
            //rnd.nextInt(26) - генерирует целое число в заданном диапазоне от 0 до указанного верхнего значения 27
            //в англ алф 26 букв, если поставить 27 и более, то будут попадаться спецсимволы
            result = result + (char) ('a' + rnd.nextInt(26));
        }
        return result;
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