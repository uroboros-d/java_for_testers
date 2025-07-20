package ru.stqa.geometry.figures;

public class Square {
    static void printSquareArea(double side) {      // для параметров нужно явное указание типа, var уже не подойдет
                                                    // static - означает, что ф-ция глобальная
        System.out.println("Площадь квадрата со стороной " + side + " = " + getSquareArea(side));
    }

    private static double getSquareArea(double side) {
        return side * side;
    }
}
