package ru.stqa.geometry.figures;

public class Square {

<<<<<<< HEAD
    private double side;
=======
    double side;        // для свойств объекта нельзя использовать var и джава потом сама догадывается, а нужно указать тип явно - double
>>>>>>> origin/main

    public Square(double side) {
        this.side = side;
    }

<<<<<<< HEAD
    public void printArea() {
        String text = String.format("Площадь квадрата со стороной %f = %f", this.side, this.getArea());
        System.out.println(text);
    }

    public double getArea() {
        return this.side * this.side;
    }

    public double getPerimeter() {
        return this.side * 4;
=======

    public static void printSquareArea(double side) {      // для параметров нужно явное указание типа, var уже не подойдет
                                                    // static - означает, что ф-ция глобальная
        String text = String.format("Площадь квадрата со стороной %f = %f", side, getArea(side));
        System.out.println(text);
    }

   public double getArea() {
        return this.side * this.side;
>>>>>>> origin/main
    }
}
