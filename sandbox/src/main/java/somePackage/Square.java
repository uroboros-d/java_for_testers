package somePackage;

public class Square {                           // класс для описания квадратa
    public double squareSideLength;             // длина стороны (квадрата)

    public Square(double squareSideLength) {    // у конструктора всегда имя как у класса и нет возвращаемого типа
        this.squareSideLength = squareSideLength;
    }

    public double area() {                      // метод вычисления площади
        return this.squareSideLength * this.squareSideLength;
    }
}
