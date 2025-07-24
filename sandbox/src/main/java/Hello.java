import java.io.File;

import java.io.File;

public class Hello {
    public static void main(String[] args) {

        // всё, что ниже, использовалось просто показать, что бывают объекты и их методы, вызывающиеся через точку

        var configFile = new File("sandbox/build.gradle");
        // создать объект файл с указанием модуля, где он находится

        System.out.println(configFile.exists());
        // проверить существование объекта класса File с пар-ром pathname = "sandbox/build.gradle"

        System.out.println(configFile.getAbsolutePath());
        // получить инф об абсолютном пути до объекта
    }
}