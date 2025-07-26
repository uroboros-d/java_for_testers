package ru.stqa.geometry.figures;

public record Triangle(double sideOne, double sideTwo, double sideThree) {

    public Triangle {
        if (sideOne < 0 || sideTwo < 0 || sideThree < 0) {
            throw new IllegalArgumentException("Triangle side must be non-negative");
        }
        if (sideOne + sideTwo < sideThree || sideOne + sideThree < sideTwo || sideTwo + sideThree < sideOne) {
            throw new IllegalArgumentException("The sum of any two triangle sides must not be less than the third triangle side");
        }
    }
    public double getPerimeter() {
        return this.sideOne + this.sideTwo + this.sideThree;
    }

    public double getArea() {
        var semiperimeter = this.getPerimeter() / 2;
        var area = Math.sqrt(semiperimeter*(semiperimeter-sideOne)*(semiperimeter-sideTwo)*(semiperimeter-sideThree));
        return area;
    }
}
