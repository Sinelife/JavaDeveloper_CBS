package _2_java_essential.homeworks.homework03;

public class Tester {
    public static void main(String[] args) {
        Shape square = new Square(10);
        Shape rectangle = new Rectangle(10, 5);
        Shape rhombus = new Rhombus(10, 30);
        Shape parallelogram = new Parallelogram(10, 5, 30);
        Shape trapeze = new Trapeze(10, 5, 4);
        Shape triangle = new Triangle(10, 5);

        getAllAreas(square, rectangle, rhombus, parallelogram, trapeze, triangle);
    }

    /**
     * Метод, который принимает параметры типа Shape и выводит их площадь
     */
    public static void getAllAreas(Shape... shapes) {
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Площадь " + shapes[i].toString() + " = " + shapes[i].getArea());
        }
    }
}
