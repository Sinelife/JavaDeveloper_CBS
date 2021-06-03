package _2_java_essential.homeworks.homework03;

public class Square extends Shape {

    protected Square(double a) {
        super(a);
    }

    @Override
    protected double getArea() {
        return a * a;
    }

    @Override
    public String toString() {
        return "Квадрат[" + a + "]";
    }
}
