import java.io.File;

public class Hello {

    public static void main(String[] args) {

        //задать переменной относительный путь к файлу "sandbox/build.gradle"
        var configFile = new File("sandbox/build.gradle");
        //получить полный путь к файлу
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());

        // получаем абсолютный путь к рабочей директории
        System.out.println(new File("").getAbsolutePath());
        // результат как в конфигурации запуска: /Users/shablinskidzmitry/repositories/java_for_testers


//        var x = 2;
//        var y = 0;
//        if (y == 0) {
//            System.out.println("Division by zero is not allowed");
//        } else {
//            var z = divide(x, y);
//            System.out.println("Hello, world!");
//        }
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}