package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side) {      // для параметров нужно явное указание типа, var уже не подойдет
                                                    // static - означает, что ф-ция глобальная
        String text = String.format("Площадь квадрата со стороной %f = %f", side, getSquareArea(side));
        System.out.println(text);
    }

    public static double getSquareArea(double side) {
        return side * side;
    }
}
