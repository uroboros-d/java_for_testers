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

    @Test
        // тест для нарушения неравенства треугольника (сумма сторон Один и Два < стороны Три)
    void cannotCreateTriangleWithTriangleInequalityViolationSideThree(){
        try {
            new Triangle(2, 3,6);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Тест выполняется успешно, при нарушении неравенства треугольника бросая исключение - выполняя блок catch");
        }
    }

    @Test
        // тест для нарушения неравенства треугольника (сумма сторон Один и Три < стороны Два)
    void cannotCreateTriangleWithTriangleInequalityViolationSideTwo(){
        try {
            new Triangle(2, 7,4);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Тест выполняется успешно, при нарушении неравенства треугольника бросая исключение - выполняя блок catch");
        }
    }

    @Test
        // тест для нарушения неравенства треугольника (сумма сторон Два и Три < стороны Один)
    void cannotCreateTriangleWithTriangleInequalityViolationSideOne(){
        try {
            new Triangle(8, 3,4);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Тест выполняется успешно, при нарушении неравенства треугольника бросая исключение - выполняя блок catch");
        }
    }

    @Test
        // тест для стороны Один треугольника = отрицательное число
    void cannotCreateTriangleWithNegativeSideOne(){
        try {
            new Triangle(-5, 4,1);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Тест выполняется успешно, при отрицательном значении длины стороны бросая исключение - выполняя блок catch");
        }
    }

    @Test
        // тест для стороны Два треугольника = отрицательное число
    void cannotCreateTriangleWithNegativeSideTwo(){
        try {
            new Triangle(5, -4,1);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Тест выполняется успешно, при отрицательном значении длины стороны бросая исключение - выполняя блок catch");
        }
    }

    @Test
        // тест для стороны Три треугольника = отрицательное число
    void cannotCreateTriangleWithNegativeSideThree(){
        try {
            new Triangle(5, 4,-1);
            // если мы прошли строку кода выше, значит поведение не соответствует ожидаемому (ожидается исключение) и
            // тест должен упасть
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Тест выполняется успешно, при отрицательном значении длины стороны бросая исключение - выполняя блок catch");
        }
    }
}
