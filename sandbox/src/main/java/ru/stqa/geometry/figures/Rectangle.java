package ru.stqa.geometry.figures;

public class Rectangle {

    double sideOne;
    double sideTwo;

    public Rectangle(double sideOne, double sideTwo) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    public void printArea() {

        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f",
                this.sideOne, this.sideTwo, this.getArea());

        System.out.println(text);
    }

    public double getArea() {

        return this.sideOne * this.sideTwo;
    }
}
