package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
        // тест для вычисления площади
    void canCalculateSquareArea() {
        var square = new Square(5.);
        var actResult = square.getArea();
        var expResult = 25.;
        Assertions.assertEquals(expResult, actResult);
    }

    @Test
        // тест для вычисления периметра
    void canCalculateSquarePerimeter() {
        Assertions.assertEquals(20., new Square(5.).getPerimeter());
    }



    @Test
        // тест для стороны квадрата = отрицательное число
    void cannotCreateSquareWithNegativeSide(){
        try {
            new Square(-5);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException удобный способ сообщить, что параметр ф-ции не считается валидным
        }
    }







}