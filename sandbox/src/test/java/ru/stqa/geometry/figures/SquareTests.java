package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    // тест для вычисления площади

    void canCalculateArea() {
<<<<<<< HEAD
        var square = new Square(6.);
=======
        var square = new Square(5.);
>>>>>>> origin/main
        var actResult = square.getArea();
        var expResult = 25.;
        Assertions.assertEquals(expResult, actResult);
    }

    @Test
    // тест для вычисления периметра

    void canCalculatePerimeter() {
        Assertions.assertEquals(20., new Square(5.).getPerimeter());
    }
}
