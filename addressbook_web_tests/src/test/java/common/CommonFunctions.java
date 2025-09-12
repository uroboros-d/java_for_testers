package common;

import java.util.Random;

public class CommonFunctions {
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
}
