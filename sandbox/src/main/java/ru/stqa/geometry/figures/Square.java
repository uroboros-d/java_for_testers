package ru.stqa.geometry.figures;

public record Square(double side) {
    public Square {
        if(side < 0){
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }

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


    public static void printSquareArea(Square square) {      // для параметров нужно явное указание типа, var уже не подойдет
        // static - означает, что ф-ция глобальная
        System.out.println("Площадь квадрата со стороной " + square.side + " = " + getSquareArea(square.side));
    }

    private static double getSquareArea(double side) { // используем параметр с тем же именем, что в прежней ф-ции,
        // но IDE понимает, что это разные переменные
        return side * side;
    }


}
