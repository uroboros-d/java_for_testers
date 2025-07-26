package ru.stqa.geometry.figures;

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
}
