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

    @Test
        // тест сравнения треугольников
    void testEquality() {
        // все возможные пары треугольников

        var triangle1_1 = new Triangle(3,4,5);
        var triangle1_2 = new Triangle(3,4,5);
        Assertions.assertEquals(triangle1_1, triangle1_2);

        var triangle2_1 = new Triangle(3,4,5);
        var triangle2_2 = new Triangle(3,5,4);
        Assertions.assertEquals(triangle2_1, triangle2_2);

        var triangle3_1 = new Triangle(3,4,5);
        var triangle3_2 = new Triangle(4,3,5);
        Assertions.assertEquals(triangle3_1, triangle3_2);

        var triangle4_1 = new Triangle(3,4,5);
        var triangle4_2 = new Triangle(4,5,1);
        Assertions.assertEquals(triangle4_1, triangle4_2);

        var triangle5_1 = new Triangle(3,4,5);
        var triangle5_2 = new Triangle(5,3,4);
        Assertions.assertEquals(triangle5_1, triangle5_2);

        var triangle6_1 = new Triangle(3,4,5);
        var triangle6_2 = new Triangle(5,4,3);
        Assertions.assertEquals(triangle6_1, triangle6_2);
    }
}
