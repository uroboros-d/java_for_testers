package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double firstSide, double secondSide) {
        System.out.println("Площадь прямоугольника со сторонами " + firstSide + " и " + secondSide + " = " + getRectangleArea(firstSide, secondSide));
    }

    public static double getRectangleArea(double firstSide, double secondSide) {
        return firstSide * secondSide;
    }
}
