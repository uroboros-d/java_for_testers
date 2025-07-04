package somePackage;

public class MyFirstProgram {

    public static void main(String[] args) {

        Square square = new Square(5);  // объект создан с помощью недефолтного определенного в классе конструктора
        System.out.println("Площадь квадрата со стороной " + square.squareSideLength + " = " + square.area());

        Rectagle rectagle = new Rectagle(6,4);
        System.out.println("Площадь прямоугольника со сторонами " + rectagle.rectangleFirstSideLength + " и " + rectagle.rectangleSecondSideLength + " = " + rectagle.area());
    }
}
