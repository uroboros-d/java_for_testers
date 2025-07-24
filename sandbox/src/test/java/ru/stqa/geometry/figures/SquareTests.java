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
        // тест для вычисления площади
    void canCalculateRectangleArea() {
        var rectangle = new Rectangle(5., 7);
        var actResult = rectangle.getArea();
        var expResult = 35.;
        Assertions.assertEquals(expResult, actResult);
    }

    @Test
        // тест для вычисления периметра
    void canCalculateRectanglePerimeter() {
        Assertions.assertEquals(16., new Rectangle(5.,3).getPerimeter());
    }
}