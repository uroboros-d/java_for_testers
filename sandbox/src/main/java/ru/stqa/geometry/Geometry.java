package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {

    public static void main(String[] args) {
        Supplier<Square> randomSquare = () -> new Square(new Random().nextDouble(100));
        var squares = Stream.generate(randomSquare).limit(5);

        squares.peek(Square::printArea).forEach(Square::printPerimeter);


//       for (Square square: squares){
//           Square.printSquareArea(square);
//       }
//       Consumer<Square> print = Square::printSquareArea;
//       squares.forEach(print);
//       Rectangle.printRectangleArea(3.0, 5.0);
//       Rectangle.printRectangleArea(7.0, 9.0);

        new Square(4.).printArea();
        new Rectangle(3., 4).printArea();
    }
}