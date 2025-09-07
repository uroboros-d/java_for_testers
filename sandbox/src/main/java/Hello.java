import java.io.File;

public class Hello {

    public static void main(String[] args) {

        var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());

        System.out.println(new File(""));
        //создаем объект с пустой строчкой в качестве параметра
        // результат: объект, который соответствует текущей рабочей директории
        System.out.println(new File("").getAbsolutePath());
        // получить абсолютный путь к рабочей директории
        // результат: /Users/shablinskidzmitry/repositories/java_for_testers
        // ровно тот же, что указан в конфигурации запуска


//        var x = 2;
//            var y = 0;
//            if (y==0) {
//                System.out.println("Division by zero is not allowed");
//            } else {
//                var z = divide(x, y);
//                System.out.println("Hello, world!");
//            }
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}