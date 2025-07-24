package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {

    public static void main(String[] args) {

        var square = new Square(4.);
        square.printArea();

        var rectangle = new Rectangle(3., 4);
        rectangle.printArea();
    }
}