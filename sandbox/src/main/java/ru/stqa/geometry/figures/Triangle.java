package ru.stqa.geometry.figures;

public record Triangle(double sideOne, double sideTwo, double sideThree) {

    public double getPerimeter() {
        return this.sideOne + this.sideTwo + this.sideThree;
    }
    public double getArea() {
        var semiperimeter = (this.sideOne + this.sideTwo + this.sideThree) * 0.5;
        var area = Math.sqrt(semiperimeter*(semiperimeter-sideOne)*(semiperimeter-sideTwo)*(semiperimeter-sideThree));
        return area;
    }
}
