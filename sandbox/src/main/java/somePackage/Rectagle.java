package somePackage;

public class Rectagle {
    public double rectangleFirstSideLength;         // длина одной стороны прямоугольника
    public  double rectangleSecondSideLength;       // длина второй стороны прямоугольника

    public Rectagle(double rectangleFirstSideLength, double rectangleSecondSideLength) {
        this.rectangleFirstSideLength = rectangleFirstSideLength;
        this.rectangleSecondSideLength = rectangleSecondSideLength;
    }

    public double area() {         // метод вычисления площади
        return this.rectangleFirstSideLength * this.rectangleSecondSideLength;
    }
}
