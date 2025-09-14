import java.io.File;

public class Hello {

    public static void main(String[] args) {

        var configFile = new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());

        var x = 2;
        var y = 0;
        if (y == 0) {
            System.out.println("Division by zero is not allowed");
        } else {
            var z = divide(x, y);
            System.out.println("Hello, world!");
        }
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}