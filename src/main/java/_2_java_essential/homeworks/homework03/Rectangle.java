package _2_java_essential.homeworks.homework03;

public class Rectangle extends Shape {

    private double b;

    protected Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    protected double getArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Прямоугольник[" + a + "," + b + "]";
    }
}
