package _2_java_essential.homeworks.homework03;

public class Parallelogram extends Shape {

    private double b;
    private double alpha;

    protected Parallelogram(double a, double b, double alpha) {
        super(a);
        this.b = b;
        this.alpha = alpha;
    }

    @Override
    protected double getArea() {
        return a * b * Math.sin((alpha * Math.PI) / 180);
    }

    @Override
    public String toString() {
        return "Паралелограм[" + a + "," + b + ",угол = " + alpha + "]";
    }
}
