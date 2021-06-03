package _2_java_essential.homeworks.homework03;

public class Triangle extends Shape {

    private double h;

    protected Triangle(double a, double h) {
        super(a);
        this.h = h;
    }

    @Override
    protected double getArea() {
        return (a * h) / 2;
    }

    @Override
    public String toString() {
        return "Триугольник[" + a + ",высота = " + h + "]";
    }
}
