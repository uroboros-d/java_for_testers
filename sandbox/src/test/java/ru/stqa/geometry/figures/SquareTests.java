package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateArea() {
        var square = new Square(5.);
        var actResult = square.getArea();
        var expResult = 25.;
        Assertions.assertEquals(expResult, actResult);

    }
}
