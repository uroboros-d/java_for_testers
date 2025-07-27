package ru.stqa.geometry.figures;

import java.util.Objects;

public record Rectangle(double sideOne, double sideTwo) {
    public Rectangle {
        if(sideOne < 0||sideTwo < 0) {
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    public void printArea() {
        String text = String.format("Площадь прямоугольника со сторонами %f и %f = %f",
                this.sideOne, this.sideTwo, this.getArea());
        System.out.println(text);
    }
    public double getArea() {
        return this.sideOne * this.sideTwo;
    }
    public double getPerimeter() {
        return this.sideOne * 2 + this.sideTwo * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.sideOne, rectangle.sideOne) == 0 && Double.compare(this.sideTwo, rectangle.sideTwo) == 0)
                ||
                (Double.compare(this.sideOne, rectangle.sideTwo) == 0 && Double.compare(this.sideTwo, rectangle.sideOne) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
