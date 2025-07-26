package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
        // тест для вычисления площади
    void canCalculateRectangleArea() {
        var rectangle = new Rectangle(5., 7);
        var actResult = rectangle.getArea();
        var expResult = 35.;
        //Assertions.assertEquals(expResult, actResult);
        if(actResult!=expResult) {
            throw new AssertionError(String.format("Expected %f, actual %f", 35., actResult));
        }
    }

    @Test
        // тест для вычисления периметра
    void canCalculateRectanglePerimeter() {
        Assertions.assertEquals(16., new Rectangle(5.,3).getPerimeter());
    }

    @Test
        // тест для стороны прямоугольника = отрицательное число
    void cannotCreateRectangleWithNegativeSide(){
        try {
            new Rectangle(-5, 4);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException удобный способ сообщить, что параметр ф-ции не считается валидным
        }
    }
}


