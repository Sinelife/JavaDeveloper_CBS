package _2_java_essential.homeworks.homework03;

public class Rhombus extends Shape {

    public double alpha;

    protected Rhombus(double a, double alpha) {
        super(a);
        this.alpha = alpha;
    }

    @Override
    protected double getArea() {
        return a * a * Math.sin((alpha * Math.PI) / 180);
    }

    @Override
    public String toString() {
        return "Ромб[" + a + ",угол = " + alpha + "]";
    }
}
