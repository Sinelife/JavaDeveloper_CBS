package _2_java_essential.homeworks.homework03;

public abstract class Shape {
    protected double a;

    protected Shape(double a) {
        this.a = a;
    }

    protected abstract double getArea();

    public abstract String toString();
}
