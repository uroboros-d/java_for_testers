package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {

    public static void main(String[] args) {
       new Square(4.).printArea();
       new Rectangle(3., 4).printArea();
    }
}