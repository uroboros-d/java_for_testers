package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double firstSide, double secondSide) {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f",
                firstSide, secondSide, getRectangleArea(firstSide, secondSide));
        System.out.println(text);
    }

    public static double getRectangleArea(double firstSide, double secondSide) {
        return firstSide * secondSide;
    }
}
