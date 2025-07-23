package ru.stqa.geometry.figures;

public class Square {

    double side;        // для свойств объекта нельзя использовать var и джава потом сама догадывается, а нужно указать тип явно - double

    public Square(double side) {
        this.side = side;
    }



    public static void printSquareArea(Square square) {      // для параметров нужно явное указание типа, var уже не подойдет
                                                    // static - означает, что ф-ция глобальная
        String text = String.format("Площадь квадрата со стороной %f = %f", square.side, square.getArea());
        System.out.println(text);
    }

   public double getArea() {
        return this.side * this.side;
    }


    public double getPerimeter() {
        return this.side * 4;
    }
}
