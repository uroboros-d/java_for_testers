package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
        // тест для вычисления площади
    void canCalculateTriangleArea() {
        var triangle = new Triangle(3., 4, 5.0);
        var actResult = triangle.getArea();
        var expResult = 6.;
        Assertions.assertEquals(expResult, actResult);
    }

    @Test
        // тест для вычисления периметра
    void canCalculateTrianglePerimeter() {
        Assertions.assertEquals(12., new Triangle(3.,4, 5.0).getPerimeter());
    }
}
