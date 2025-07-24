package ru.stqa.geometry.figures;

public record Square(double side) {

    public void printArea() {
        String text = String.format("Площадь квадрата со стороной %f = %f", this.side, this.getArea());
        System.out.println(text);
    }
    public double getArea() {
        return this.side * this.side;
    }
    public double getPerimeter() {
        return this.side * 4;
    }
}
