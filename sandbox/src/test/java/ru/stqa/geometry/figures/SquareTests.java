package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {

    @Test
    void canCalculateArea() {
        var actResult = Square.getSquareArea(5.);
        var expResult = 25.;
        Assertions.assertEquals(expResult, actResult);

    }
}
